export class Luhn {
  constructor(number) {
    this._number = number.replace(/\s/g, "");
  }

  get valid() {
    const validity = this.check_validity();
    Object.defineProperty(this, "valid", { value: validity });
    return validity;
  }

  check_validity() {

    if (this._number.length < 2)
      return false;

    if (/[^\d]/.test(this._number))
      return false;

    let double_this_digit = this._number.length % 2 === 0;
    let sum = 0;

    for (let digit of this._number) {

      digit = Number(digit);

      if (double_this_digit) {
        digit *= 2;
        if (digit > 9)
          digit -= 9;
      }

      sum += digit;
      double_this_digit = !double_this_digit;

    }

    return sum % 10 === 0;
  }
}
