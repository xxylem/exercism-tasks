/** INPUT: sentence (string)
*   OUTPUT: true if sentence is a pangram, i.e. it contains
              every letter of the English alphabet at least once. */
export const isPangram = (sentence) => {

  sentence = new Set(
    sentence.toLowerCase().replace(/[^a-z]/g, ''));

  return sentence.size == 26;

};


