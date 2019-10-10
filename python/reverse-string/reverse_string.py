def reverse(input=''):
    ''' Input is a string. Output is the reverse of that string.
    '''
    if len(input) < 2:
        # String length 0 or 1 is already reversed
        return input
    temp_string = ''
    counter = 0
    for i in range(len(input) -1, -1, -1):
        # Go from index at last position of input string down to 0 and concatenate
        # to a new string
        temp_string += input[i]
        counter += 1
    return temp_string
