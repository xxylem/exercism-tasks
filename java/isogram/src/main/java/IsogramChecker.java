import java.util.Set;
import java.util.stream.Collectors;

class IsogramChecker {

    boolean isIsogram(String phrase) {

        String letters = phrase.toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> lettersSet = letters.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toSet());

        return letters.length() == lettersSet.size();
    }

}
