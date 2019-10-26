export class Words {

  count(words) {

    let word_count = {}
    const split_words = words.toLowerCase().trim().split(/\s+/);
    
    for (const word of split_words) {

      if (word_count.hasOwnProperty(word))
        word_count[word]++;

      else
        word_count[word] = 1;
    }

    return word_count;
  }
}
