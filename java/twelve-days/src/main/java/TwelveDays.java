class TwelveDays {

    String verse(int verseNumber) {
        // I would return a StringBuilder to use it in verses, but the tests
        // expect a String.
        StringBuilder sb = new StringBuilder(startOfVerse(verseNumber));
        sb.append(endOfVerse(verseNumber));
        sb.append('\n');
        return sb.toString();
    }

    String verses(int startVerse, int endVerse) {

        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++) {
            sb.append(verse(i));
            sb.append('\n');
        }

        // Separate since test data does not expect the extra newline for the final verse.
        sb.append(verse(endVerse));
        return sb.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }

    private StringBuilder startOfVerse(int day) {
        return new StringBuilder(
                String.format("On the %s day of Christmas my true love gave to me: ", ordinalDay(day)));
    }

    private StringBuilder endOfVerse(int day) {
        StringBuilder sb = new StringBuilder();
        for (int i = day; i > 1; i--)
            sb.append(gift(i));
        if (sb.length() > 0)
            sb.append("and ");
        sb.append(gift(1));
        return sb;
    }

    private String ordinalDay(int day) {
        switch (day) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                throw new IllegalArgumentException("Bad day.");
        }
    }

    private StringBuilder gift(int day) {
        switch (day) {
            case 1:
                return new StringBuilder("a Partridge in a Pear Tree.");
            case 2:
                return new StringBuilder("two Turtle Doves, ");
            case 3:
                return new StringBuilder("three French Hens, ");
            case 4:
                return new StringBuilder("four Calling Birds, ");
            case 5:
                return new StringBuilder("five Gold Rings, ");
            case 6:
                return new StringBuilder("six Geese-a-Laying, ");
            case 7:
                return new StringBuilder("seven Swans-a-Swimming, ");
            case 8:
                return new StringBuilder("eight Maids-a-Milking, ");
            case 9:
                return new StringBuilder("nine Ladies Dancing, ");
            case 10:
                return new StringBuilder("ten Lords-a-Leaping, ");
            case 11:
                return new StringBuilder("eleven Pipers Piping, ");
            case 12:
                return new StringBuilder("twelve Drummers Drumming, ");
            default:
                throw new IllegalArgumentException("Bad day.");
        }
    }
}
