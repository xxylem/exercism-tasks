export class Matrix {
  constructor(matrix_string) {
    this.matrix_string = matrix_string;
  }
  
  get rows() {
    const matrix = this.matrix_string.split("\n")
      .map(str => str.split(' ').map(Number));
    
    Object.defineProperty(this, "rows", { value: matrix });
    return matrix;
  }

  get columns() {
    const mat_transpose = 
      this.rows[0].map((_, i) => this.rows.map(row => row[i]));

    Object.defineProperty(this, "columns", { value: mat_transpose});
    return mat_transpose;
  }
}
