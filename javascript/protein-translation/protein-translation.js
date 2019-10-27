const translate_codon = (codon) => {

  switch (codon) {

    case "AUG":	
      return "Methionine";

    case "UUU": case "UUC":	
      return "Phenylalanine";

    case "UUA": case "UUG":
      return "Leucine";

    case "UCU": case "UCC": case "UCA": case "UCG":	
      return "Serine";

    case "UAU": case "UAC":	
      return "Tyrosine";

    case "UGU": case "UGC":	
      return "Cysteine";

    case "UGG":	
      return "Tryptophan";

    default:
      throw new Error('Invalid codon');
  }
}

const is_stop = (codon) => {
  return codon === "UAA" || codon === "UAG" || codon === "UGA";
}

export const translate = (rna_strand) => {

  const codon_pattern = /[A-Z]{3}/g;
  let protein_sequence = []
  let match;

  while (match = codon_pattern.exec(rna_strand)) {

    const codon = match[0];

    if (is_stop(codon)) 
      return protein_sequence;

    protein_sequence.push(translate_codon(codon));
  }
  
  return protein_sequence;
};
