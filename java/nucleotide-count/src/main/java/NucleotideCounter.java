import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

    private Map<Character, Integer> nucleotideCounts;
    private static final ArrayList<Character> nucleotides = new ArrayList<>(
            Arrays.asList('A', 'C', 'G', 'T'));

    NucleotideCounter(String dnaStrand) {
        nucleotideCounts = new HashMap<>();
        for (char nucleotide : nucleotides)
            nucleotideCounts.put(nucleotide, 0);

        for (char nucleotide : dnaStrand.toCharArray()) {
            if (!isValidNucleotide(nucleotide))
                throw new IllegalArgumentException();

            nucleotideCounts.put(nucleotide, nucleotideCounts.get(nucleotide) + 1);
        }
    }

    private boolean isValidNucleotide(char c) {
        return nucleotides.contains(c);
    }


    Map<Character, Integer> nucleotideCounts() {
        return nucleotideCounts;
    }
}