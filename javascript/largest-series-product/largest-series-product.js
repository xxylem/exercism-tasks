const computeProduct = number_str =>
  [...number_str].reduce((a, b) => a * b, 1);

const computeLargestProduct = 
  slice_size => input_number => {

    const end = input_number.length - slice_size;
    let max = 0;
    for (let i = 0; i <= end; i++) {
      max = Math.max(max, computeProduct(input_number.slice(i, i + slice_size)));
    }
    return max;
};

export const largestProduct = (input_number, slice_size) => {

  if (/[^\d]/g.test(input_number) || slice_size < 0)
    throw new Error('Invalid input.');

  if (slice_size > input_number.length)
    throw new Error('Slice size is too big.');

  if (slice_size === 0)
    return 1;

  return input_number
            .split('0')
            .map(computeLargestProduct(slice_size))
            .reduce((a, b) => Math.max(a, b), 0);
};
