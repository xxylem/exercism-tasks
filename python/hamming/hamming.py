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
    
    # Iterate over the same character in each string (parallel, not nested)
    for x in range(len(strand_a)):
        # Check for parity
        if strand_a[x] != strand_b[x]:
            # Increment Hamming counter
            hamming_distance += 1
    
    # Return the Hamming distance
    return hamming_distance    