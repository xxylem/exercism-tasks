/** INPUT: a positive integer n
 *  OUTPUT: the number of steps to reach 1 by the 
 *          rules of the Collatz conjecture. */
export const steps = (n) => {

  // Check bad argument.
  if (n < 1)
    throw new Error('Only positive numbers are allowed');
  
  // Base case
  if (n == 1)
    return 0;

  // Inductive step (n even)
  else if (n % 2 == 0)
    return 1 + steps(n / 2);
  
  // Inductive step (n odd)
  else 
    return 1 + steps(3 * n + 1);
  


};
