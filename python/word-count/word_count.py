import string, re, collections


def count_words(phrase):
    '''
    Given a phrase, count the occurrences of each word in that phrase.
    Input: phrase (string) to test
    Output: dictionary of words found with number of occurrences associated with each
    '''
    
    # Use regex to split the phrase by commas, underscores and whitespace.
    # Strip any extra punctuation around the words and put everything in lowercase.
    words = [word.strip(string.punctuation).lower() for word in 
                re.split(f"[,_{string.whitespace}]", phrase)]

    # Build the count of each word in the phrase.
    word_counter = collections.Counter()
    for word in words:
        if word:
            word_counter[word] += 1
        
    return word_counter