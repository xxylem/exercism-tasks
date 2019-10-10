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

def word_count(phrase):
    '''
    Given a phrase, count the occurrences of each word in that phrase.
    Input: phrase (string) to test
    Output: dictionary of words found with number of occurrences associated with each
    '''
    
    words_found = {}
    current_word = ''
    length_phrase = len(phrase)
    i = 0 # index for loop
    
    while i < length_phrase:
        
        if phrase[i].isdigit(): # deals with digits
            current_word += phrase[i] 
            
        elif phrase[i].isalpha(): # deals with letters
            current_word += phrase[i].lower()
            
        elif phrase[i] == '\'': # deals with apostrophes
            if i + 1 >= length_phrase: # avoids attempting to index out of range
                pass
            elif current_word == '': # ignores leading apostrophes from words
                pass
            elif phrase[i + 1].isalpha():
                # adds apostrophe to word only if it is in the middle of a word
                current_word += phrase[i].lower()
            # Other possibilities are passed over
        else:
            # Adds word to dict only if there is something to add, then
            # resets the current word
            add_word_to_dict(words_found, current_word)
            current_word = ''
        i += 1 # Increment index for while loop (for loop also possible, but since
                # we need to look around the current index, while seemed easier
        
    # To account for final word in phrase
    add_word_to_dict(words_found, current_word)
    
    return words_found