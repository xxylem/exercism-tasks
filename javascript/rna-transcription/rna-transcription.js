/** INPUT: a DNA strand (string)
 *  OUTPUT: the input dna_strand converted to an RNA strand (string)
 *  ASSUMES: dna_strand is a valid DNA strand. */
export const toRna = (dna_strand) => {

  return [...dna_strand].map((nucleotide =>
    nucleotide_translations[nucleotide] )).join('');  
};

const nucleotide_translations = { 'G': 'C'
                                , 'C': 'G'
                                , 'T': 'A'
                                , 'A': 'U' };
