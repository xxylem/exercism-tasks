def is_valid(isbn):
    ''' 
    Checks if a given ISBN-10 is valid.
    Input (string): ISBN to test
    Output (bool): True if valid, otherwise False
    '''
       
    # Check valid length and remove hyphen
    isbn = isbn.replace("-", "")
    if len(isbn) != 10:
        return False

    multiplicand = 10
    checksum = 0
    for char in isbn:

        if char.isdigit():
            checksum += int(char) * multiplicand

        elif char == "X" and multiplicand == 1:
            # Only the last "digit" can be X: We can reuse the multiplicand var
            # to check for this
            checksum += 10

        else:
            # Not a valid character
            return False
        multiplicand -= 1
    
    return checksum % 11 == 0