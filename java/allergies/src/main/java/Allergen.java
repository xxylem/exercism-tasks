import java.util.Arrays;
import java.util.stream.Stream;

enum Allergen {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128);

    private final int score;

    Allergen(int score) {
        this.score = score;
    }

    public static Stream<Allergen> stream() {
        return Arrays.stream(Allergen.values());
    }

    int getScore() {
        return score;
    }
}
