export const primeFactors = (number) => {

  const factors = []
  let current_factor = 2;

  while (number > 1) {

    if (number % current_factor === 0) {
      
      factors.push(current_factor);
      number /= current_factor;
    }

    else
      current_factor++;
  }

  return factors;
};
