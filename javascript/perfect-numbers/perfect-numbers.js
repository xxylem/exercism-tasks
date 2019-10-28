const factors = (n) => {

  let small_factors = [];
  let big_factors = [];
  // Factors come in pairs, we only need to look for the pairs
  // up to sqrt(n).
  const end = Math.sqrt(n);

  for (let i = 1; i <= end; i++) {

    if (n % i === 0) {

      small_factors.push(i);
      
      if(i * i !== n)
        big_factors.push(n / i);
    }
  }

  // Big factors are added largest first so this puts all 
  // factors in ascending order for the convenience of the caller.
  big_factors.reverse();

  return small_factors.concat(big_factors);
}

export const classify = (number) => {

  if (number < 1)
    throw new Error('Classification is only possible for natural numbers.')

  // slice off last element because we want the sum of the factors of a number 
  // not including the number itself.
  const aliquot_sum = factors(number).slice(0, -1).reduce((a,b) => a + b, 0);
  
  return aliquot_sum > number ? 'abundant'
          : aliquot_sum === number ? 'perfect'
                                      : 'deficient';
};
