import string

def is_pangram(sentence):
    ''' Determine if a sentence is a pangram.
        Returns True if sentence (a string) is a pangram.
        Otherwise, returns False
    '''
    alpha = string.ascii_lowercase
        
    sentence = sentence.lower()
        
    for char in sentence:
        alpha = alpha.replace(char, "")
                
    if alpha == "":
        return True
    else:
        return False
