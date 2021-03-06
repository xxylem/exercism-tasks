class Hamming {

    private final String leftStrand;
    private final String rightStrand;
    private final int len;
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {

        int lenL = leftStrand.length();
        int lenR = rightStrand.length();

        // Sanity check on arguments.
        if (lenL == 0 && lenR > 0)
            throw new IllegalArgumentException(
                "left strand must not be empty.");
        if (lenR == 0 && lenL > 0)
            throw new IllegalArgumentException(
                "right strand must not be empty.");
        if (lenL != lenR)
            throw new IllegalArgumentException(
                "leftStrand and rightStrand must be of equal length.");

        this.len = lenL;
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        computeHammingDistance();

    }

    // Getter
    int getHammingDistance() { return hammingDistance; }

    private void computeHammingDistance() {
        
        int dist = 0;

        for (int i = 0; i < len; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)){
                dist += 1;
            }
        }

        hammingDistance = dist;
    }

}
