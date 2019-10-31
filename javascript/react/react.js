class CellManager {
  constructor() {
    // input/compute cell -> compute cell
    this.cellDependencies = new Map();

    // Compute cell -> callback 
    this.cellCallbacks = new Map();

    // Records compute cells that have updated their value
    this.registeredComputeCellChanges = new Set();
  }

  addDependency(independentCell, dependentCell) {
    if (!this.cellDependencies.has(independentCell))
      this.cellDependencies.set(independentCell, new Set([dependentCell]));
    
    this.cellDependencies.get(independentCell).add(dependentCell);
  }

  addCallbackDependency(computeCell, callbackCell) {
    if (!this.cellCallbacks.has(computeCell))
      this.cellCallbacks.set(computeCell, new Set([callbackCell]));

    this.cellCallbacks.get(computeCell).add(callbackCell);
  }

  removeCallbackDependency(computeCell, callbackCell) {
    if (this.cellCallbacks.has(computeCell)) {
      if (this.cellCallbacks.get(computeCell).length === 1) {
        this.cellCallbacks.delete(computeCell);
      }
      else {
        this.cellCallbacks.get(computeCell).delete(callbackCell);
      }
    }
  }

  registerInputCellChange(inputCell) {
    if (!this.cellDependencies.has(inputCell))
      return;

    // Tell compute cells about the change
    for (const dep of this.cellDependencies.get(inputCell)) {
      dep.updateValue();
    }

    this.updateComputeCells();
    this.updateCallbackCells();
  }

  registerComputeCellChange(computeCell) {
    this.registeredComputeCellChanges.add(computeCell);
  }

  updateComputeCells() {
    for (const computeCell of this.registeredComputeCellChanges) {
      if (this.cellDependencies.has(computeCell)) {
        for (const dep of this.cellDependencies.get(computeCell)) {
          dep.updateValue();
        }
      }
    }
  }

  updateCallbackCells() {
    for (const computeCell of this.registeredComputeCellChanges) {
      if (this.cellCallbacks.has(computeCell)) {
        for (const callbackCell of this.cellCallbacks.get(computeCell)) {
          callbackCell.updateValues(computeCell);
        }
      }
    }
    this.registeredComputeCellChanges.clear();
  }
}

var cm = new CellManager();

export class InputCell {
  constructor(value) {
    this.value = value;
  }

  setValue(value) {
    if (this.value === value) {
      return;
    }

    this.value = value;
    cm.registerInputCellChange(this);
  }

  addDependency(cell) {
    cm.addDependency(this, cell);
  }
}

export class ComputeCell {
  constructor(inputCells, fn) {
    this.inputCells = inputCells
    this.fn = fn;
    this.value = this.fn(this.inputCells);
    for (const inputCell of this.inputCells) {
      inputCell.addDependency(this);
    }

  }

  updateValue() {
    const newVal = this.fn(this.inputCells);
    if (this.value === newVal) {
      return;
    }

    this.value = newVal;
    cm.registerComputeCellChange(this);
  }

  addDependency(cell) {
    cm.addDependency(this, cell);
  }

  addCallback(cb) {
    cm.addCallbackDependency(this, cb);
  }

  removeCallback(cb) {
    cm.removeCallbackDependency(this, cb);
  }
}

export class CallbackCell {
  constructor(fn) {
    this.fn = fn;
    this.values = [];
  }

  updateValues(cell) {
    this.values.push(this.fn(cell));
  }
}
