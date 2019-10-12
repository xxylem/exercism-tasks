def distance(strand_a, strand_b):
    '''
    Calculates the Hamming distance between two DNA strands
    Input: strand_a and strand_b (both strings) to be tested
    Output (int): Hamming distance
    Raises ValueError exception for strings of different lengths
    '''
    
    # Check for strings of different lengths and raise a value error if so
    if len(strand_a) != len(strand_b):
        raise ValueError("DNA strands are not the same length. Please check and try again")

    hamming_distance = 0
    
    # Calculate number of characters that differ
    for (a, b) in zip(strand_a, strand_b):
        if a != b:
            hamming_distance += 1

    return hamming_distance