import java.util.HashMap;
import java.util.Map;

class House {

    private static Map<Integer, StringBuilder> nounPhrases = new HashMap<>();
    private static Map<Integer, StringBuilder> verbPhrases = new HashMap<>();
    static {
        nounPhrases.put(1, new StringBuilder("the house that Jack built"));
        nounPhrases.put(2, new StringBuilder("the malt"));
        nounPhrases.put(3, new StringBuilder("the rat"));
        nounPhrases.put(4, new StringBuilder("the cat"));
        nounPhrases.put(5, new StringBuilder("the dog"));
        nounPhrases.put(6, new StringBuilder("the cow with the crumpled horn"));
        nounPhrases.put(7, new StringBuilder("the maiden all forlorn"));
        nounPhrases.put(8, new StringBuilder("the man all tattered and torn"));
        nounPhrases.put(9, new StringBuilder("the priest all shaven and shorn"));
        nounPhrases.put(10, new StringBuilder("the rooster that crowed in the morn"));
        nounPhrases.put(11, new StringBuilder("the farmer sowing his corn"));
        nounPhrases.put(12, new StringBuilder("the horse and the hound and the horn"));

        verbPhrases.put(1, new StringBuilder("lay in"));
        verbPhrases.put(2, new StringBuilder("ate"));
        verbPhrases.put(3, new StringBuilder("killed"));
        verbPhrases.put(4, new StringBuilder("worried"));
        verbPhrases.put(5, new StringBuilder("tossed"));
        verbPhrases.put(6, new StringBuilder("milked"));
        verbPhrases.put(7, new StringBuilder("kissed"));
        verbPhrases.put(8, new StringBuilder("married"));
        verbPhrases.put(9, new StringBuilder("woke"));
        verbPhrases.put(10, new StringBuilder("kept"));
        verbPhrases.put(11, new StringBuilder("belonged to"));
    }

    String sing() {
        return verses(1, 12);
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verses = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            verses.append(verse(i));
            if (i != endVerse)
                verses.append("\n");
        }
        return verses.toString();
    }

    String verse(int verseNumber) {

        return firstLine(verseNumber)
                .append(middleLines(verseNumber))
                .append(lastLine(verseNumber))
                .toString();


    }

    private static StringBuilder firstLine(int verseNumber) {
        StringBuilder line = new StringBuilder("This is ");
        line.append(nounPhrases.get(verseNumber));
        return line;
    }

    private static StringBuilder middleLines(int verseNumber) {
        StringBuilder lines = new StringBuilder();
        for (int i = verseNumber - 1; i > 1; i--) {
            lines.append(" that ")
                .append(verbPhrases.get(i))
                .append(" ")
                .append(nounPhrases.get(i));
        }

        return lines;
    }

    private static StringBuilder lastLine(int verseNumber) {
        StringBuilder line = new StringBuilder();
        if (verseNumber > 1) {
            line.append(" that ")
                .append(verbPhrases.get(1))
                .append(" ")
                .append(nounPhrases.get(1));
        }

        line.append(".");
        return line;
    }
}