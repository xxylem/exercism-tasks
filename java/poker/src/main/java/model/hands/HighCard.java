package model.hands;

import model.Card;
import model.Hand;

import java.util.List;

public class HighCard extends Hand {

    HighCard(String cards) {
        super(cards);
    }

    @Override
    public int compareTo(Hand hand) {
        if (hand instanceof HighCard) {
            HighCard other = (HighCard) hand;
            List<Card.CardValue> thisVals = this.cardValuesSorted();
            List<Card.CardValue> otherVals = other.cardValuesSorted();
            for (int i = 0; i < 5; i++) {
                int diff = thisVals.get(i).compareTo(otherVals.get(i));
                if (diff != 0)
                    return diff;
            }
            return 0;
        }

        return -1;
    }
}
