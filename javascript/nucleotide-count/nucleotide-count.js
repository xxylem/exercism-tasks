export class NucleotideCounts {

  constructor() {
    this.A = 0;
    this.C = 0;
    this.G = 0;
    this.T = 0;
  }

  toString() {
    return [this.A, this.C, this.G, this.T].join(' ');
  }

  add(nucleotide) {
    
    if (!this.hasOwnProperty(nucleotide))
      throw new Error('Invalid nucleotide in strand');

    this[nucleotide]++;
  }

  static parse(strand) {

    const nc = new NucleotideCounts();
    [...strand].forEach(nc.add, nc);
    return nc.toString();
  }
}
