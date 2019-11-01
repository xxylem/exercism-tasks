import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Anagram {

    private final String word;
    private final char[] wordSorted;

    Anagram(String word) {
        this.word = word;
        this.wordSorted = sortAndNormaliseString(word);
    }


    List<String> match(List<String> candidates) {
        // I wish I didn't have to stream and unstream the list or this would be even simpler.
        return candidates.stream().filter(this::isAnagram).collect(Collectors.toList());
    }

    private boolean isAnagram(String candidate) {
        return !this.word.equalsIgnoreCase(candidate)
                && Arrays.equals(this.wordSorted, sortAndNormaliseString(candidate));
    }

    private static char[] sortAndNormaliseString(String word) {
        char[] temp = word.toLowerCase().toCharArray();
        Arrays.sort(temp);
        return temp;
    }
}