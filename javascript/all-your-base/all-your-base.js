const convertToDecimal = (digits, inBase) => {

  let multiplicand = 1;
  let sum = 0;
  for (const digit of digits.reverse()) {

    if (digit < 0 || digit >= inBase)
      throw new Error('Input has wrong format');

    sum += digit * multiplicand;
    multiplicand *= inBase;
  }
  return sum;
};

const convertFromDecimal = (number, outBase) => {

  if (number === 0)
    return [0];

  let digits = [];
  while (number) {
    digits.push(number % outBase);
    number = Math.floor(number / outBase);
  }

  return digits.reverse();

}

const validateBase = base => 
  base !== undefined && Number.isInteger(base) && base > 1;

export const convert = (digits, inBase, outBase) => {

  if (!validateBase(inBase))
    throw new Error('Wrong input base');

  if (!validateBase(outBase))
    throw new Error('Wrong output base');

  if (digits.length === 0)
    throw new Error('Input has wrong format');

  // Leading zeros are forbidden by test cases.
  if (digits.length > 1 && digits[0] === 0)
    throw new Error('Input has wrong format');

  return convertFromDecimal(convertToDecimal(digits, inBase), outBase);
};
