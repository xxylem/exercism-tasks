import java.util.List;
import java.util.stream.Collectors;

class Allergies {

    private final int score;

    Allergies(int score) {
        this.score = score;
    }

    public boolean isAllergicTo(Allergen allergen) {
        // Allergens are signified by a bit flag in an 8-bit int.
        return (score & allergen.getScore()) > 0;
    }

    public List<Allergen> getList() {
        return Allergen
                .stream()
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }
}
