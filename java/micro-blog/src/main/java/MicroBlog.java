import java.text.Normalizer;

class MicroBlog {
    public String truncate(String input) {

        input.codePoints().mapToObj(c -> (char)c).forEachOrdered(System.out::println);
        return "";
    }
}
