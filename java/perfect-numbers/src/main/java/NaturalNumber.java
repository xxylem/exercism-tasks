import java.util.HashSet;
import java.util.Set;

class NaturalNumber {

    private final int n;

    NaturalNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.n = n;
    }

    public Classification getClassification() {
        int aliquotSum = computeAliquotSum();
        return aliquotSum > n
                ? Classification.ABUNDANT
                : aliquotSum == n
                ? Classification.PERFECT
                : Classification.DEFICIENT;
    }

    protected int computeAliquotSum() {
        return getFactors()
                .stream()
                .reduce(0, Integer::sum);
    }

    protected Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        int maxBound = 1 + (n / 2);
        for (int i = 1; i < maxBound; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

}
