export const validate = (number) => {
  
  const digits = String(number);
  const num_digits = digits.length;

  return number == [...digits].reduce( (total, num) =>
    total + num ** num_digits, 0);
};
