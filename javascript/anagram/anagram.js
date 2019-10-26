export class Anagram {
  constructor(word) {

    this.original_word = word;
    this.original_word_upper = word.toUpperCase();
    this.original_word_lower_sorted = this.original_word.toLowerCase()
        .split('').sort().join('');

  }

  matches(potentials) {

    let matches_found = [];

    for (const potential of potentials) {

      if (potential.toUpperCase() == this.original_word_upper)
        continue;

      const potential_lower_sorted = potential.toLowerCase()
          .split('').sort().join('');

      if (potential_lower_sorted == this.original_word_lower_sorted)
        matches_found.push(potential);
    }

    return matches_found;
  }
}
