package model.hands;

import model.Card;
import model.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pair extends Hand {

    Card.CardValue pairValue;
    List<Card.CardValue> kickersSorted;

    Pair(String cards) {
        super(cards);
        Map<Card.CardValue, Long> valuesCounts = cardValueCounts();
        for (Card.CardValue key : valuesCounts.keySet()) {
            if (valuesCounts.get(key) == 2L)
                pairValue = key;
            else
                kickersSorted.add(key);
        }
        kickersSorted = kickersSorted.stream().sorted().collect(Collectors.toList());
    }


    @Override
    public int compareTo(Hand hand) {
        if (hand instanceof Pair) {
            Pair other = (Pair) hand;
            int diff = this.pairValue.compareTo(other.pairValue);

            if (diff != 0)
                return diff;

            for (int i = 0; i < 3; i++) {
                diff = this.kickersSorted.get(i).compareTo(other.kickersSorted.get(i));
                if (diff != 0)
                    return diff;
            }
            return 0;
        }

        if (hand instanceof HighCard)
            return 1;

        return -1;
    }
}
