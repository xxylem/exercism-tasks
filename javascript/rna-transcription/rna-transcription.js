/** INPUT: a DNA strand (string)
 *  OUTPUT: the input dna_strand converted to an RNA strand (string)
 *  ASSUMES: dna_strand is a valid DNA strand. */
export const toRna = (dna_strand) => {

  let rna_strand = '';
  for (const nucleotide of dna_strand) {
    rna_strand += nucleotide_translations[nucleotide];
  }

  return rna_strand;
};

const nucleotide_translations = { 'G': 'C'
                                , 'C': 'G'
                                , 'T': 'A'
                                , 'A': 'U' };
