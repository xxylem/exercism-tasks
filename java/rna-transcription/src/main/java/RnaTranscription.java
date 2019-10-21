class RnaTranscription {

    String transcribe(String dnaStrand) {
        char[] nucleotides = dnaStrand.toCharArray();
        int len = nucleotides.length;
        for (int i = 0; i < len; i++)
            nucleotides[i] = transcribe(nucleotides[i]);
        return new String(nucleotides);
    }

    char transcribe(char nucleotide) {
        switch (nucleotide) {
            case 'G':
                return 'C';
            case 'C':
                return 'G';
            case 'T':
                return 'A';
            case 'A':
                return 'U';
            default:
                throw new IllegalArgumentException("DNA strand contains invalid nucleotide.");
        }
    }
}