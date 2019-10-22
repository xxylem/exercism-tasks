import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    static private final String vowelSounds = "^([aeiou]|yt|xr)(?:\\w*)?";
    static private final Pattern consonantCluster = Pattern.compile(
            "(^[a-z&&[^aeiouq]]*qu|^[a-z&&[^aeiou]][a-z&&[^aeiouy]]*)(\\w*)");

    // ASSUMES: Input contains only lowercase letters.
    String translate(String phrase) {
        return Stream.of(phrase.split(" "))
                .map (this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {

        if (word.matches(vowelSounds))
            return word + "ay";

        Matcher consonantClusterMatcher = consonantCluster.matcher(word);
        if (consonantClusterMatcher.matches()) {
            String cluster = consonantClusterMatcher.group(1);
            String restOfWord = consonantClusterMatcher.group(2);
            return restOfWord + cluster + "ay";
        }

        throw new IllegalArgumentException("Bad word found: " + word);
    }
}