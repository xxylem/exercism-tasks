import re

def is_isogram(phrase):
    ''' Determine if a word or phrase is an isogram.
        Input is a phrase to test
        Output is bool: True if is isogram, otherwise False'''

    # Get all the letters used in the word or phrase and
    # convert them to lower case.
    letters = re.sub(r"[^A-Za-z]", '', phrase).lower()

    # Check for duplicates
    return len(letters) == len(set(letters))
   