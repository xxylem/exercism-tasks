import java.util.StringTokenizer;

class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(phrase, " _-");

        while (st.hasMoreTokens())
            sb.append(Character.toUpperCase(st.nextToken().charAt(0)));

        acronym = sb.toString();
    }

    String get() { return acronym; }
}
