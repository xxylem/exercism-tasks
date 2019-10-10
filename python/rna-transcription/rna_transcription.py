def to_rna(dna_strand):
    ''' Transcribes input dna_strand (string) to RNA.
        Outputs this as a string
    '''
    
    # Empty string to write transcribed RNA strand to
    rna_strand = ''
    
    # Iterate over the nucleotides in the DNA strand
    for nucleotide in dna_strand:
        # Check for valid nucleotides and transcribe them
        if nucleotide == 'G':
            rna_strand += 'C'
        elif nucleotide == 'C':
            rna_strand += 'G'
        elif nucleotide == 'T':
            rna_strand += 'A'
        elif nucleotide == 'A':
            rna_strand += 'U'
        # Any other value is invalid - raise exception
        else:
            raise ValueError("Invalid DNA strand input. Please check")
    return rna_strand
