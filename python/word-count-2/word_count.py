import string, re

def add_word_to_dict(words_found, current_word):
    '''
    Input: words_found (dictionary), current_word (string) to add to dictionary
    Only adds the current word if it has data, otherwise does nothing.
    Always returns 0
    '''
    if len(current_word) != 0:
            if current_word in words_found:
                words_found[current_word] += 1
            else:
                words_found[current_word] = 1
    return 0

def count_words(phrase):
    '''
    Given a phrase, count the occurrences of each word in that phrase.
    Input: phrase (string) to test
    Output: dictionary of words found with number of occurrences associated with each
    '''
    
    words_found = {}

    words = [word.strip(string.punctuation).lower() for word in 
                re.split(f"[,_{string.whitespace}]", phrase)]
    for word in words:
        add_word_to_dict(words_found, word)
        
    return words_found