import java.util.Formatter;

class Proverb {

    private final String proverb;

    Proverb(String[] words) {

        int len = words.length;
        if (len == 0) {
            proverb = "";
            return;
        }

        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        // The Formatter will feed its output into the StringBuilder since
        // they are linked above;
        for (int i = 0; i < len - 1; i++)
            fmt.format("For want of a %s the %s was lost.\n", words[i], words[i + 1]);

        fmt.format("And all for the want of a %s.", words[0]);

        proverb = sb.toString();
    }

    String recite() {
        return proverb;
    }
}
