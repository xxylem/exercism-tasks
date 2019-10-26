export class Words {

  count(words) {

    let word_count = {}
    const split_words = words.toLowerCase().trim().split(/[\t\n ]+/);
    
    for (const word of split_words) {

      if (typeof word_count[word] === "number")
        word_count[word]++;

      else
        word_count[word] = 1;
    }

    return word_count;
  }
}
