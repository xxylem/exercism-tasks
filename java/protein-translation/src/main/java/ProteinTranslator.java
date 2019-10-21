import java.util.LinkedList;
import java.util.List;

class ProteinTranslator {

    private enum Codon {
        AUG, UUU, UUC, UUA, UUG, UCU, UCC, UCA, UCG,
        UAU, UAC, UGU, UGC, UGG, UAA, UAG, UGA;

        boolean isStop() {
            switch (this) {
                case UAA:
                case UAG:
                case UGA:
                    return true;
                default:
                    return false;
            }
        }

        String translate() {
            switch (this) {
                case AUG:
                    return "Methionine";
                case UUU:
                case UUC:
                    return "Phenylalanine";
                case UUA:
                case UUG:
                    return "Leucine";
                case UCU:
                case UCC:
                case UCA:
                case UCG:
                    return "Serine";
                case UAU:
                case UAC:
                    return "Tyrosine";
                case UGU:
                case UGC:
                    return "Cysteine";
                case UGG:
                    return "Tryptophan";
                default:
                    throw new IllegalArgumentException("Invalid codon.");
            }
        }
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new LinkedList<>();

        // Get codons from rnaSequence
        int n = rnaSequence.length();
        for (int i = 0; i < n - 2; i+=3) {

            Codon codon = Codon.valueOf(rnaSequence.substring(i, i + 3));

            if (codon.isStop())
                break;

            else
                proteins.add(codon.translate());
        }

        return proteins;
    }








}