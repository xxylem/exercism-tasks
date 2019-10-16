/** INPUT: sentence (string)
*   OUTPUT: true if sentence is a pangram, i.e. it contains
              every letter of the English alphabet at least once. */
export const isPangram = (sentence) => {

  const letters_found = new Set(
    sentence.toLowerCase().match(/[a-z]/g));

  return letters_found.size === 26;

};


