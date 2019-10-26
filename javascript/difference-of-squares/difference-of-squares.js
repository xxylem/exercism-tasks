export class Squares {
  constructor(number) {
    this.number = number
  }

  get sumOfSquares() {
    const n = this.number;
    const sum = ((2 * n + 1) * n * (n + 1)) / 6;
    Object.defineProperty(this, 'sumOfSquares', { value: sum });
    return sum;
  }

  get squareOfSum() {
    const n = this.number
    const sum = (n * (n + 1)) / 2;
    const sumSq = sum * sum;
    Object.defineProperty(this, 'squareOfSum', { value: sumSq });
    return sumSq;
  }

  get difference() {
    const diff = this.squareOfSum - this.sumOfSquares;
    Object.defineProperty(this, 'difference', { value: diff });
    return diff;
  }
}
