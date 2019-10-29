import BigInt from './lib/big-integer';

export class Grains {
  square(n) {
    return BigInt(1).shiftLeft(n - 1).toString();
  }

  total() {
    let sum = BigInt(0);

    for (let i = 1; i <= 64; i++)
      sum = sum.add(1).shiftLeft(1);

    return sum.shiftRight(1).toString();
  }
}
