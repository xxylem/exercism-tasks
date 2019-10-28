export const isIsogram = (phrase) => {
  
  let letters_seen = {};
  const phrase_norm = phrase.toUpperCase();

  for (const c of phrase_norm) {

    if (/[^A-Z]/.test(c)) 
      continue;

    if (letters_seen[c])
      return false;

    letters_seen[c] = true;
  }

  return true;
};
