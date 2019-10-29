// ASSUMES: letter is a member of the upper-case English alphabet.
const getLetterScore = (letter) => {

  switch (letter) {
      case 'Q': case 'Z':
        return 10;
      case 'J': case 'X':
        return 8;
      case 'K':
        return 5;
      case 'F': case 'H': case 'V': case 'W': case 'Y':
        return 4;
      case 'B': case 'C': case 'M': case 'P':
        return 3;
      case 'D': case 'G':
        return 2;
      default:
        return 1; 
  }
}

export const score = (word) => {
  return [...word.toUpperCase()].map(getLetterScore).reduce((a, b) => a + b, 0);
};
