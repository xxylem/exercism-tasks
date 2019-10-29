const is_palindrome = number => {

  const number_str = String(number);
  const end = number_str.length / 2;

  for (let i = 0; i < end; i++) {

    if (number_str.charAt(i) !== number_str.charAt(number_str.length - 1 - i))
      return false;
  }  

  return true;
}

/* Finds the smallest product of two integers in the given range,
    s.t. the product is a palindromic number. */
const computeSmallestPalindromeIn = range => {

  let smallest = {
    value: Infinity,
    factors: []
  };

  // The idea is to quickly reduce the search space once a viable
  // product is found. If i and j are the smallest factors of a palindromic 
  // product so far, then any other product must have factors no larger than
  // max(i, j)
  let maxFactor = range.maxFactor;
  for (let i = range.minFactor; i <= maxFactor; i++) {
    for (let j = i; j <= maxFactor; j++) {
      
      const prod = i * j;

      // No more possible products with this value of i.
      if (prod > smallest.value)
        break;
      
      if (!is_palindrome(prod))
        continue;

      if (prod === smallest.value) {
        smallest.factors.push([i, j]);
        // Reduces the search window
        maxFactor = Math.max(i, j);
        break;
      }
      
      if (prod < smallest.value) {
        smallest.value = prod;
        // Reduces the search window
        smallest.factors = [[i, j]];
        maxFactor = Math.max(i, j);
        break;
      }             
    }
  }

  if (smallest.value === Infinity)
    smallest.value = null;

  return smallest;
};

/* Finds the largest product of two integers in the given range,
    s.t. the product is a palindromic number. */
const computeLargestPalindromeIn = range => {

  let largest = {
    value: -Infinity,
    factors: []
  };

  let minFactor = range.minFactor;

  for (let i = range.maxFactor; i >= minFactor; i--) {
    for (let j = i; j >= minFactor; j--) {
      
      const prod = i * j;

      if (prod < largest.value)
        break;
      
      if (!is_palindrome(prod))
        continue;

      if (prod === largest.value) {
        largest.factors.push([i, j]);
        // Reduces the search window
        minFactor = Math.min(i, j);
        break;
      }
      
      if (prod > largest.value) {
        largest.value = prod;
        largest.factors = [[i, j]];
        // Reduces the search window
        minFactor = Math.min(i, j);
        break;
      }             
    }
  }

  if (largest.value === -Infinity)
    largest.value = null;

  return largest;
}

export class Palindromes {

  static generate(range) {

    if (range.minFactor > range.maxFactor)
      throw new Error('min must be <= max');

    const p = new Palindromes();
    Object.defineProperty(p, "smallest", 
      { value: computeSmallestPalindromeIn(range) } );
    Object.defineProperty(p, "largest", 
      { value: computeLargestPalindromeIn(range) } );
    return p;
  }
}
