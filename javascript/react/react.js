/* The CellManager manages dependencies between InputCells, ComputeCells
   and CallbackCells. In particular, it ensures that changes to InputCells
   fully propagate to all ComputeCells before then informing CallbackCells
   of any changes to ComputeCells. */
class CellManager {
  constructor() {
    // Stores dependencies for relationships:
      // InputCell -> ComputeCell
      // ComputeCell -> ComputeCell
    this.cellDependencies = new Map();

    // Stores dependencies for relationship:
      // ComputeCell -> CallbackCell
    this.cellCallbacks = new Map();

    // We need both kinds of dependencies because a Callback cannot trigger until all
    // changes have propagated through all ComputeCells that the Callback depends on,
    // since the ComputeCell may settle on the same value it had originally despite
    // intermediate ComputeCells changing.

    // Temporarily stores ComputeCells that have told the CellManager that their 
    // value has changed. ComputeCells in these sets have not been processed yet.
    this.computeCellsChangedNeedToInformDeps = new Set();
    this.computeCellsChangedNeedToInformCallbacks = new Set();
  }

  /* Add an InputCell -> ComputeCell or a ComputeCell -> ComputeCell 
  / dependency relationship.  */
  addDependency(independentCell, dependentCell) {
    if (this.cellDependencies.has(independentCell))
      this.cellDependencies.get(independentCell).add(dependentCell);
    
    else
      this.cellDependencies.set(independentCell, new Set([dependentCell]));
  }

  /* Add a ComputeCell -> CallbackCell dependency relationship. */
  addCallbackDependency(computeCell, callbackCell) {
    if (this.cellCallbacks.has(computeCell))
      this.cellCallbacks.get(computeCell).add(callbackCell);
    
    else
      this.cellCallbacks.set(computeCell, new Set([callbackCell]));
  }

  /* Remove a ComputeCell -> CallbackCell dependency relationship. */
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

  /* Informs the CellManager that the value of the given InputCell has changed
  /  and propagates the change through the system. */
  registerInputCellChange(inputCell) {
    // The order of propagation of updates must be very precise to prevent CallbackCells
    // being triggered unnecessarily. All ComputeCells must be fully updated before
    // CallbackCells are considered.

    // Simple case: nothing depends on the InputCell's value.
    if (!this.cellDependencies.has(inputCell))
      return;

    // Tell compute cells that immediately depend on the InputCell about the change
    this.cellDependencies.get(inputCell).forEach(dep => dep.updateValue())

    // Then, recursively update the values of all ComputeCells that depend
    // indirectly on this InputCell.
    this.updateComputeCells();

    // Finally, update the values of any CallbackCells that depend on any
    // ComputeCells that changed.
    this.updateCallbackCells();
  }

  /* Informs the CellManager that the value of a ComputeCell has changed */
  registerComputeCellChange(computeCell) {
    // We only log that a change has ocurred here. We cannot act yet because
    // a ComputeCell may have many dependencies that each need to change first.
    this.computeCellsChangedNeedToInformDeps.add(computeCell);
    this.computeCellsChangedNeedToInformCallbacks.add(computeCell);
  }

  /* Recursively updates all the ComputeCells whose dependencies have changed. */
  updateComputeCells() {
    this.computeCellsChangedNeedToInformDeps.forEach(computeCell => {
      if (this.cellDependencies.has(computeCell))
        this.cellDependencies.get(computeCell).forEach(dep => dep.updateValue());
  
      // This ComputeCell has fully informed all its dependencies of its change.
      this.computeCellsChangedNeedToInformDeps.delete(computeCell);
    })

    // Since the dependencies may have changed, we now need to update their dependencies.
    // This is not necessary for the test suite, but allows for arbitrary depth of dependencies.
    if (this.computeCellsChangedNeedToInformDeps.length > 0)
      this.updateComputeCells();
  }

  /* Tells CallbackCells to update if any ComputeCells they directly depend
     on have changed. */
  updateCallbackCells() {
    this.computeCellsChangedNeedToInformCallbacks.forEach(computeCell => {
      if (this.cellCallbacks.has(computeCell)) {
        this.cellCallbacks.get(computeCell).forEach(callbackCell =>
          callbackCell.updateValues(computeCell));
      }
    });
  
    this.computeCellsChangedNeedToInformCallbacks.clear();
  }
}

// Due to the design of the test suite, I have to use a globally accessible
// CellManager. I would prefer to have the following usage:
  // Create a CellManager. 
  // Then ask the CellManager to create Cells.
  // The Cells are associated with that CellManager.
  // Dependencies are automatically established by the CellManager upon creation
  // or upon request.
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
}

export class ComputeCell {
  constructor(inputCells, fn) {
    this.inputCells = inputCells
    this.fn = fn;
    this.value = this.fn(this.inputCells);

    // This isn't ideal since I am calling functions with "this" from the constructor.
    // I would prefer the CellManager to create this Cell and automatically handle
    // the dependency.
    this.inputCells.forEach(inputCell => cm.addDependency(inputCell, this));
  }

  /* Called when an InputCell has changed its value. The ComputeCell recalulates
     its value, and if it's new, informs the CellManager. */
  updateValue() {
    const newVal = this.fn(this.inputCells);
    if (this.value === newVal) {
      return;
    }

    this.value = newVal;
    cm.registerComputeCellChange(this);
  }

  // Again, it would be preferable for the CellManager to handle this directly, but
  // here I simply pass the request through anyway.
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
