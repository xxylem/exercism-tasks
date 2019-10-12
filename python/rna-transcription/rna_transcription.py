def to_rna(dna_strand):
    ''' Transcribes input dna_strand (string) to RNA.
        Outputs this as a string
    '''

    nucleotide_translations =   { 'G': 'C' 
                                , 'C': 'G'
                                , 'T': 'A'
                                , 'A': 'U' }

    
    rna_strand = ''
    
    for nucleotide in dna_strand:
        if nucleotide not in nucleotide_translations:
            raise ValueError("Invalid DNA strand input. Please check")
        rna_strand += nucleotide_translations[nucleotide]
  
    return rna_strand