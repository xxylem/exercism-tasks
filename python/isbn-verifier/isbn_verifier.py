def verify(isbn):
    ''' 
    Checks if a given ISBN-10 is valid.
    Input (string): ISBN to test
    Output (bool): True if valid, otherwise False
    '''
    
    # Constant values according to specification for ISBN-10
    MODULUS = 11
    VALUE_OF_CHAR_X = 10
    ISBN_10_LENGTH = 10
    INITIAL_MULTIPLIER = 10
    
    # Strip "-" character, that we can expect according to spec.
    isbn = isbn.replace("-", "")
    
    # Refute invalid lengths immediately
    if len(isbn) != ISBN_10_LENGTH:
        return False
    
    # Store running total for checksum formula
    checksum = 0
    # Store initial value of multiplier we will iterate down from
    multiplier = INITIAL_MULTIPLIER
    
    for char in isbn:
        if char.isdigit():
            checksum += int(char) * multiplier
        elif char == "X" and multiplier == 1:
            # Only the last "digit" can be X: We can reuse the multiplier var
            # to check for this
            checksum += VALUE_OF_CHAR_X * multiplier
        else:
            # Not a valid character
            return False
        multiplier -= 1
    
    # Returns bool
    return checksum % MODULUS == 0