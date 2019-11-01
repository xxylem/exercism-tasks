import { transpose } from 'mathjs'

export class Matrix {
  constructor(matrix_string) {
    this.mat = matrix_string.split("\n")
          .map(str => str.split(' ').map(Number));
  }

  get rows() {
    return this.mat;
  }

  get columns() {
    return transpose(this.mat);
  }

  get saddlePoints() {
  }
}
