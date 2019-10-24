CODON_TRANSLATIONS = {
    "AUG": "Methionine",
    "UGG": "Tryptophan",
}
CODON_TRANSLATIONS.update(dict.fromkeys(["UUU", "UUC"], "Phenylalanine"))
CODON_TRANSLATIONS.update(dict.fromkeys(["UUA", "UUG"], "Leucine"))
CODON_TRANSLATIONS.update(dict.fromkeys(["UCU", "UCC", "UCA", "UCG"], "Serine"))
CODON_TRANSLATIONS.update(dict.fromkeys(["UAU", "UAC"], "Tyrosine"))
CODON_TRANSLATIONS.update(dict.fromkeys(["UGU", "UGC"], "Cysteine"))


def is_stop(codon):
    return codon == "UAA" or codon == "UAG" or codon == "UGA"


def proteins(strand):

    if len(strand) % 3 != 0:
        raise ValueError("RNA sequences must only be composed of length-3 codons.")

    proteins_found = []
    while len(strand) > 0:
        codon = strand[0:3]
        strand = strand[3:]

        if is_stop(codon):
            return proteins_found

        proteins_found.append(CODON_TRANSLATIONS[codon])

    return proteins_found






