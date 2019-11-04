import java.util.HashMap;
import java.util.Map;

class Scrabble {

    // Map of letters to their values.
    private static final Map<Character, Integer> letterValues = createMap();
    private static Map<Character, Integer> createMap() {
        Map<Character, Integer> letterValues = new HashMap<>();
        "aeioulnrst".chars()
                .mapToObj(letter -> (char) letter)
                .forEach(letter -> letterValues.put(letter, 1));
        letterValues.put('d', 2);
        letterValues.put('g', 2);
        "bcmp".chars()
                .mapToObj(letter -> (char) letter)
                .forEach(letter -> letterValues.put(letter, 3));
        "fhvwy".chars()
                .mapToObj(letter -> (char) letter)
                .forEach(letter -> letterValues.put(letter, 4));
        letterValues.put('k', 5);
        letterValues.put('j', 8);
        letterValues.put('x', 8);
        letterValues.put('q', 10);
        letterValues.put('z', 10);
        return letterValues;
    }



    private final String word;
    private final int score;

    Scrabble(String word) {
        this.word = word.toLowerCase();

        // Calculate score
        int tempScore = 0;
        for (char letter : this.word.toCharArray())
            tempScore += letterValues.get(letter);
        score = tempScore;
    }

    // Getter
    int getScore() { return score; }
}