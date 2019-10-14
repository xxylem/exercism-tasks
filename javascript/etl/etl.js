/** INPUT: letters_by_score: object with letters listed under each possible score.
 *  OUTPUT: scores listed under each separate letter.
 *  NOTE: Does not modify the original input object. */
export const transform = (old_score_system) => {

  let new_score_system = {};
  
  for (const [score, letters] of Object.entries(old_score_system)) {
    for (const letter of letters) {
      new_score_system[letter.toLowerCase()] = parseInt(score);
    }
  }

  return new_score_system;
};
