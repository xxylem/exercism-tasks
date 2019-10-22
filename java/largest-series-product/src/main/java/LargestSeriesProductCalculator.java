import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LargestSeriesProductCalculator {

    private final List<Integer> digits;
    private final int size;
    private HashMap<Integer, Long> largestProducts;


    LargestSeriesProductCalculator(String inputNumber) {
        ArrayList<Integer> tempDigits = new ArrayList<>();

        for (char c : inputNumber.toCharArray()){
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("String to search may only contain digits.");
            tempDigits.add(Character.getNumericValue(c));
        }

        // Makes an immutable copy of the list of digits.
        digits = List.copyOf(tempDigits);
        size = digits.size();

        // Used to store already computed largest products.
        largestProducts = new HashMap<>();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > size )
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");

        // Only compute if we haven't already.
        return largestProducts.computeIfAbsent(numberOfDigits, this::findLargestProduct);
    }

    private long findLargestProduct(int numberOfDigits) {
        long largest = 0;
        for (int i = 0; i <= size - numberOfDigits; i++) {
            long newProduct = computeProduct(i, i + numberOfDigits);
            if (newProduct > largest)
                largest = newProduct;
        }
        return largest;
    }

    private long computeProduct(int start, int end) {
        long product = 1;
        for (int i = start; i < end; i++)
            product *= digits.get(i);
        return product;
    }
}
