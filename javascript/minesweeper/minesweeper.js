export const annotate = (input) =>  {

  if (input.length === 0)
    return input;

  if (input[0].length === 0)
    return input

  const board = input.map(str => [...str]);
  
  const m = board.length;
  const n = board[0].length;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == ' ') {

        let mine_count = 0;

        // Above-Left
        if (i > 0 && j > 0 && board[i - 1][j - 1] === '*')
          mine_count++;

        // Above
        if (i > 0 && board[i - 1][j] === '*')
          mine_count++;

        // Above-Right
        if (i > 0 && j < n - 1 && board[i - 1][j + 1] === '*')
          mine_count++;

        // Left
        if (j > 0 && board[i][j - 1] === '*')
          mine_count++;

        // Right
        if (j < n - 1 && board[i][j + 1] === '*')
          mine_count++;
              
        // Below-Left
        if (i < m - 1 && j > 0 && board[i + 1][j - 1] === '*')
          mine_count++;

        // Below
        if (i < m - 1 && board[i + 1][j] === '*')
          mine_count++;

        // Below-Right
        if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] === '*')
          mine_count++;

        if (mine_count > 0)
          board[i][j] = mine_count;
      }
    }
  }

  return board.map(arr => arr.join(''));
}
