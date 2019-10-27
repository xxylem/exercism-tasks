
const convertHundreds = (hundreds) => {
  switch (hundreds) {
    case 9:
      return 'CM';
    case 8:
      return 'DCCC';
    case 7:
      return 'DCC';
    case 6:
      return 'DC';
    case 5:
      return 'D';
    case 4:
      return 'CD';
    case 3:
      return 'CCC';
    case 2:
      return 'CC';
    case 1:
      return 'C';
    default:
      return '';  
  }
}

const convertTens = (tens) => {
  switch (tens) {
    case 9:
      return 'XC';
    case 8:
      return 'LXXX';
    case 7:
      return 'LXX';
    case 6:
      return 'LX';
    case 5:
      return 'L';
    case 4:
      return 'XL';
    case 3:
      return 'XXX';
    case 2:
      return 'XX';
    case 1:
      return 'X';
    default:
      return '';
  }
}

const convertOnes = (ones) => {
  switch (ones) {
    case 9:
      return 'IX';
    case 8:
      return 'VIII';
    case 7:
      return 'VII';
    case 6:
      return 'VI';
    case 5:
      return 'V';
    case 4:
      return 'IV';
    case 3:
      return 'III';
    case 2:
      return 'II';
    case 1:
      return 'I';
    default:
      return '';
  }
}

export const toRoman = (number) => {
  let decimal = number;
  let numeral = "";

  const thousands = Math.floor(decimal / 1000);
  numeral += 'M'.repeat(thousands);

  decimal %= 1000;

  const hundreds = Math.floor(decimal / 100);
  numeral += convertHundreds(hundreds);

  decimal %= 100;

  const tens = Math.floor(decimal / 10);
  numeral += convertTens(tens);

  decimal %= 10;

  const ones = decimal;
  numeral += convertOnes(ones);

  return numeral;
};
