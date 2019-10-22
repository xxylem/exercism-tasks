import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    // Patterns are of the form:
    // (prefix)(rest)
    // The prefix will be moved after rest before adding "ay".

    static private final Pattern vowelSounds = Pattern.compile(
            // For vowels, there is nothing in the prefix.                      The rest must start with a vowel sound.
            "(?<prefix>)"                                                       + "(?<rest>^([aeiou]|yt|xr)\\w*)");


    static private final Pattern consonantClusterQu = Pattern.compile(
            // The prefix is any consonant cluster followed by qu.              The rest can be anything.
            "(?<prefix>^([a-z&&[^aeiouq]]|q(?!u))*qu)"                          + "(?<rest>\\w*)");


    static private final Pattern consonantClusterY = Pattern.compile(
            // The prefix is any consonant cluster except
            // those starting or ending in y.                                   The rest starts with a y.
            "(?<prefix>^([a-z&&[^aeiouy]])([a-z&&[^aeiouy]]|y(?![aeiou]))*)"    + "(?<rest>y\\w*)");


    static private final Pattern consonantCluster = Pattern.compile(
            // The prefix is any cluster of at least one consonant.             The rest can be anything.
            "(?<prefix>^[a-z&&[^aeiou]]+)"                                      + "(?<rest>\\w*)");


    // If you make a new pattern, add it to this list. Take care to add patterns in order from most specific
    // to most general.
    static private final ArrayList<Pattern> PATTERNS = new ArrayList<>(Arrays.asList(
            vowelSounds,
            consonantClusterQu,
            consonantClusterY,
            consonantCluster));

    // ASSUMES: Input contains only lowercase letters.
    String translate(String phrase) {
        return Stream.of(phrase.split(" "))
                .map (this::translateWord)
                .collect(Collectors.joining(" "));
    }

    /* Tries to apply the translation patterns in the order given in PATTERNS.
     Returns the first translation that succeeds.
     SIDE-EFFECTS: Throws an IllegalArgumentException if no pattern matches.*/
    private String translateWord(String word) {

        for (Pattern pattern : PATTERNS) {
            Optional<String> maybeWord = tryApplyPattern(word, pattern);
            if (maybeWord.isPresent())
                return maybeWord.get();
        }

        throw new IllegalArgumentException("Bad word found: " + word);
    }

    /* Attempts to use the given pattern to move the prefix after rest, before finally adding "ay". */
    private Optional<String> tryApplyPattern(String word, Pattern pattern) {

        Matcher consonantClusterMatcher = pattern.matcher(word);

        if (consonantClusterMatcher.matches()) {

            String prefix = consonantClusterMatcher.group("prefix");
            String restOfWord = consonantClusterMatcher.group("rest");

            return Optional.of(restOfWord + prefix + "ay");

        }

        return Optional.empty();
    }
}