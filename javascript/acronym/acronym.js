const acronym_letter_pattern =
  /(?<=^|[_ -])([a-z])/gi;

export const parse = (phrase) => {

  let acronym = "";
  let match;

  while (match = acronym_letter_pattern.exec(phrase))
    acronym += match[0].toUpperCase();

  return acronym;
};
