import java.util.Optional;

class Markdown {

    private static final String STRONG_MARKDOWN_RE = "__(.+)__";
    private static final String STRONG_HTML_RE = "<strong>$1</strong>";
    private static final String EMPHASIS_MARKDOWN_RE = "_(.+)_";
    private static final String EMPHASIS_HTML_RE = "<em>$1</em>";

    String parse(String markdown) {

        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();

        boolean activeList = false;

        for (String line : lines) {

            Optional<String> parsedLine;

            if ((parsedLine = parseListItem(line)).isPresent()) {
                // Line is a list item
                if (!activeList) {
                    activeList = true;
                    result.append("<ul>");
                }
                result.append(parsedLine.get());
                continue;
            }

            if (activeList) {
                activeList = false;
                result.append("</ul>");
            }

            result.append(
                    parseHeader(line)
                    .orElse(parseParagraph(line)));
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private Optional<String> parseHeader(String markdown) {
        int count;
        for (count = 0; count < markdown.length() && markdown.charAt(count) == '#'; count++) {}

        return count > 0
                ? Optional.of("<h" + count + ">" + markdown.substring(count + 1) + "</h" + count + ">")
                : Optional.empty();
    }

    private Optional<String> parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.substring(2);
            String listItemString = replaceAnyEmphasisMarkers(skipAsterisk);
            return Optional.of("<li>" + listItemString + "</li>");
        }

        return Optional.empty();
    }

    private String parseParagraph(String markdown) {
        return "<p>" + replaceAnyEmphasisMarkers(markdown) + "</p>";
    }


    private String replaceAnyEmphasisMarkers(String markdown) {
        return markdown
                .replaceAll(STRONG_MARKDOWN_RE, STRONG_HTML_RE)
                .replaceAll(EMPHASIS_MARKDOWN_RE, EMPHASIS_HTML_RE);
    }
}