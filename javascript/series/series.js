export class Series {

  constructor(digits) {

    this._digits = [...digits].map(Number);
    this._num_digits = this._digits.length;

  }

  get digits() { return this._digits; }

  slices(n) {

    if (n > this._num_digits)
      throw new Error('Slice size is too big.');

    let slices_found = [];
    for (let i = 0; i + n <= this._num_digits; i++)
      slices_found.push(this._digits.slice(i, i + n));
    
    return slices_found;
  }
}
