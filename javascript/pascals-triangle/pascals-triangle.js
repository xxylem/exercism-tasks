
export const rows = n => {
  if (n == 0) {
    return [];
  }

  let triangle = [[1]];

  for (let i = 1; i < n; i++) {
    let prevRow = triangle[i - 1];

    // Zip together two copies of the previous row, offset 1 position.
    let prevRowLeft = [0].concat(prevRow);
    let prevRowRight = prevRow.concat([0]);

    let newRow = [];
    for (let j = 0; j < prevRowLeft.length; j++) {
      newRow[j] = prevRowLeft[j] + prevRowRight[j];
    }

    triangle.push(newRow);
  }

  return triangle;
};
