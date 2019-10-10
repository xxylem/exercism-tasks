def is_isogram(string):
    ''' Determine if a word or phrase is an isogram.
        Input is a string to test
        Output is bool: True if is isogram, otherwise False'''
    
    # Keep record of letters found so far
    letters_found = ''
    
    # Iterate over full length of input string
    for char in string:
        # Ignore punctuaction
        if char.isalpha():
            # Ignore case
            if char.lower() in letters_found:
                return False
            else:
                letters_found += char.lower()
    return True
