import java.util.HashMap;
import java.util.Map;

class Scrabble {

    // Map of letters to their values.
    private static final Map<Character, Integer> letterValues = createMap();
    private static Map<Character, Integer> createMap() {
        Map<Character, Integer> letterValues = new HashMap<>();
        "aeioulnrst".chars()
                .forEach(letter -> letterValues.put((char) letter, 1));
        "dg".chars()
                .forEach(letter -> letterValues.put((char) letter, 2));
        "bcmp".chars()
                .forEach(letter -> letterValues.put((char) letter, 3));
        "fhvwy".chars()
                .forEach(letter -> letterValues.put((char) letter, 4));
        letterValues.put('k', 5);
        "jx".chars()
                .forEach(letter -> letterValues.put((char) letter, 8));
        "qz".chars()
                .forEach(letter -> letterValues.put((char) letter, 10));
        return letterValues;
    }

    private final String word;
    private final int score;

    Scrabble(String word) {
        this.word = word.toLowerCase();

        // Calculate score
        this.score = this.word
                .chars()
                .map(letter -> letterValues.get((char) letter))
                .sum();
    }

    // Getter
    int getScore() { return score; }
}