import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Yacht {

    private final List<Integer> dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.stream(dice)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            // Logic assumes there are exactly five dice, sorted in descending order.
            case YACHT:
                return dice.get(0).equals(dice.get(4)) ? 50 : 0;
            case ONES:
                return numbersScore(1);
            case TWOS:
                return numbersScore(2);
            case THREES:
                return numbersScore(3);
            case FOURS:
                return numbersScore(4);
            case FIVES:
                return numbersScore(5);
            case SIXES:
                return numbersScore(6);
            case FULL_HOUSE:
                return isValidFullHouse()
                        ? dice.stream().reduce(0, Integer::sum)
                        : 0;
            case FOUR_OF_A_KIND:
                return isValidFourOfAKind()
                        ? dice.get(2) * 4 // Dice are sorted so the middle dice are definitely one of the four.
                        : 0;
            case LITTLE_STRAIGHT:
                return isValidLittleStraight()
                        ? 30
                        : 0;
            case BIG_STRAIGHT:
                return isValidBigStraight()
                        ? 30
                        : 0;
            case CHOICE:
                return dice.stream().reduce(0, Integer::sum);
        }
        return -1;
    }

    private boolean isValidFullHouse() {
        return dice.get(0).equals(dice.get(2))
                    && !dice.get(2).equals(dice.get(3))
                    && dice.get(3).equals(dice.get(4))
                || dice.get(0).equals(dice.get(1))
                    && !dice.get(1).equals(dice.get(2))
                    && dice.get(2).equals(dice.get(4));
    }

    private boolean isValidFourOfAKind() {
        return dice.get(0).equals(dice.get(3))
                || dice.get(1).equals(dice.get(4));
    }

    private boolean isValidLittleStraight() {
        return dice.get(0) == 5
                && dice.get(1) == 4
                && dice.get(2) == 3
                && dice.get(3) == 2
                && dice.get(4) == 1;
    }

    private boolean isValidBigStraight() {
        return dice.get(0) == 6
                && dice.get(1) == 5
                && dice.get(2) == 4
                && dice.get(3) == 3
                && dice.get(4) == 2;
    }

    private int numbersScore(int number) {
        return dice.stream().reduce(0,
                (rsf, d) -> d == number ? rsf + d : rsf);
    }

}
