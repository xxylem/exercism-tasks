export class InputCell {
  constructor(value) {
    this.value = value;
    this.callbacks = new Set();
  }

  addCallback(cb) {
    this.callbacks.add(cb);
  }

  setValue(value) {
    if (this.value !== value) {
      this.value = value;
      for (const callback of this.callbacks) {
        callback.update();
      }
    }
  }

  update() {

  };
}

export class ComputeCell {
  constructor(inputCells, fn) {
    this.inputCells = inputCells;
    for (const inputCell of this.inputCells) {
      inputCell.addCallback(this);
    }
    this.fn = fn;
    this.callbacks = new Set();
    this.update();
  }

  update() {
    for (const inputCell of this.inputCells)
      inputCell.update();

    const newVal = this.fn(this.inputCells);
    if (newVal === this.value) {
      return;
    }

    this.value = newVal;

    for (const callback of this.callbacks) {
      callback.update(this);
    }
  }

  addCallback(cb) {
    this.callbacks.add(cb);
  }

  removeCallback(cb) {
    this.callbacks.delete(cb);
  }
}

export class CallbackCell {
  constructor(fn) {
    this.fn = fn;
    this.values = [];
  }

  update(computeCell) {
    this.values.push(this.fn(computeCell));
  }
}
