'''
Implemented Bob's phrases as a dictionary this time to make it easier to
change, add or delete his phrases in the future. This could be stored in a
separate file, for instance.
'''

bobs_phrases = {    "nothing":            'Fine. Be that way!',
                    "forceful_question":  'Calm down, I know what I\'m doing!',
                    "shout":              'Whoa, chill out!',
                    "question":           'Sure.',
                    "general":            'Whatever.'
                
                }


def hey(phrase):
    '''
    Bob responds to you based on what you say
    
    Inputs: phrase (string): whatever you want to say to Bob
    
    Returns: Bob's response to you (string)
    
    '''
    
    # Altered logic to simplify code: strip phrase in advance of if clauses
    # and nest the two conditions that depend on UPPER CASE
    #                   Credit for idea to: zaneundrscr
    
    phrase = phrase.strip()
    
    # if you say nothing
    if not phrase:
        return bobs_phrases["nothing"]
    
    elif phrase.isupper():
        # if you shout [CAPS] and ask a question [? at end]
        if phrase[-1] == '?':
            return bobs_phrases["forceful_question"]
    
        # if you just shout [CAPS]
        else:
            return bobs_phrases["shout"]
    
    # if you just ask a question [? at end]
    elif phrase[-1] == '?':
        return bobs_phrases["question"]
     
    # all other cases
    else:
        return bobs_phrases["general"]
