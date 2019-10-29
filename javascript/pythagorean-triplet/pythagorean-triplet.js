const tolerance = 0.00001

export class Triplet {
  // ASSUMES: a, b, c are positive integers and a < b < c
  constructor(a, b, c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  sum() {
    return this.a + this.b + this.c;
  }

  product() {
    return this.a * this.b * this.c;
  }

  isPythagorean() {
    return Math.abs(Math.hypot(this.a, this.b) - this.c) < tolerance;
  }

  static where({ minFactor: minFactor = 0,
                 maxFactor: maxFactor,
                 sum : sumCondition }) {
    
    const triplets = [];
    const ignoreSumCondition = sumCondition === undefined;

    // This is a very straightforward solution but it seems
    // sufficient for the given test cases, which complete quickly.
    // If speed becomes a problem, I could implement the divide-and-
    // conquer search for triplets that I did for the Python version
    // of this problem.
    for (let a = minFactor; a < maxFactor - 1; a++) {
      for (let b = a + 1; b < maxFactor; b++) {
        for (let c = b + 1; c <= maxFactor; c++) {

          const triplet = new Triplet(a, b, c);

          if (triplet.isPythagorean() && 
            (ignoreSumCondition || triplet.sum() === sumCondition))
            triplets.push(triplet);
        }
      }
    }

    return triplets;
  }
}
