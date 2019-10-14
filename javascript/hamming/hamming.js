/** INPUT: Two DNA strands, left_strand (string) and right_strand (string)
 *  OUTPUT: The Hamming distance between the two strands.
 *  SIDE-EFFECTS: Throws error on empty strings and strings of nonequal length. */
export const compute = (left_strand, right_strand) => {
  
  // Validate arguments
  if (left_strand.length == 0 && right_strand.length > 0)
      throw new Error('left strand must not be empty');
  
  if (right_strand.length == 0 && left_strand.length > 0)
      throw new Error('right strand must not be empty');

  if (left_strand.length != right_strand.length)
    throw new Error('left and right strands must be of equal length');
  // End validate arguments

  // Calculate Hamming distance
  let distance = 0;
  let n = left_strand.length;
  for (let i = 0; i < n; i++) {
    if (left_strand.charAt(i) != right_strand.charAt(i))
      distance++;
  }

  return distance;
};
