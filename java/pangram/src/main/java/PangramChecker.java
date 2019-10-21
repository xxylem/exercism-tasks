import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String input) {

        Set<Character> lettersSeen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c))
                lettersSeen.add(Character.toLowerCase(c));

            if (lettersSeen.size() >= 26)
                return true;

        }

        return false;
    }
}
