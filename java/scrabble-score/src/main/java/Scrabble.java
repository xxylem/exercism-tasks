import java.util.HashMap;
import java.util.Map;

class Scrabble {

    // Map of letters to their values.
    private static final Map<Character, Integer> letterValues = createMap();
    private static Map<Character, Integer> createMap() {
        Map<Character, Integer> letterValues = new HashMap<>();
        letterValues.put('a', 1);
        letterValues.put('b', 3);
        letterValues.put('c', 3);
        letterValues.put('d', 2);
        letterValues.put('e', 1);
        letterValues.put('f', 4);
        letterValues.put('g', 2);
        letterValues.put('h', 4);
        letterValues.put('i', 1);
        letterValues.put('j', 8);
        letterValues.put('k', 5);
        letterValues.put('l', 1);
        letterValues.put('m', 3);
        letterValues.put('n', 1);
        letterValues.put('o', 1);
        letterValues.put('p', 3);
        letterValues.put('q', 10);
        letterValues.put('r', 1);
        letterValues.put('s', 1);
        letterValues.put('t', 1);
        letterValues.put('u', 1);
        letterValues.put('v', 4);
        letterValues.put('w', 4);
        letterValues.put('x', 8);
        letterValues.put('y', 4);
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