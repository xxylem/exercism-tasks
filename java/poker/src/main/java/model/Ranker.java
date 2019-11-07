package model;

import java.util.List;
import java.util.Map;

import static model.Rank.HIGH_CARD;

public class Ranker {

    public static Rank computeRank(Hand h) {
        return isStraightFlush(h) ?
                Rank.STRAIGHT_FLUSH :
                isFourOfAKind(h) ?
                        Rank.FOUR_OF_A_KIND :
                        isFullHouse(h) ?
                                Rank.FULL_HOUSE :
                                isFlush(h) ?
                                        Rank.FLUSH :
                                        isStraight(h) ?
                                                Rank.STRAIGHT :
                                                isThreeOfAKind(h) ?
                                                        Rank.THREE_OF_A_KIND :
                                                        isTwoPair(h) ?
                                                                Rank.TWO_PAIR :
                                                                isPair(h) ?
                                                                        Rank.PAIR :
                                                                        HIGH_CARD;

    }

    private static boolean isStraightFlush(Hand h) {
        if (h.cardSuitCounts().size() != 1)
            return false;

        List<Card.CardValue> values = h.cardValuesSorted();

        if (values.size() != 5)
            return false;

        return values.get(4).ordinal() - values.get(0).ordinal() == 4;
    }

    private static boolean isFourOfAKind(Hand h) {
        Map<Card.CardValue, Long> valueCounts = h.cardValueCounts();

        if (valueCounts.size() != 2)
            return false;

        return valueCounts.containsValue(1L) && valueCounts.containsValue(4L);
    }

    private static boolean isFullHouse(Hand h) {
        Map<Card.CardValue, Long> valueCounts = h.cardValueCounts();

        if (valueCounts.size() != 2)
            return false;

        return valueCounts.containsValue(2L) && valueCounts.containsValue(3L);
    }

    private static boolean isFlush(Hand h) {
        Map<Card.Suit, Long> suitCounts = h.cardSuitCounts();

        return suitCounts.size() == 1;
    }

    private static boolean isStraight(Hand h) {
        if (h.cardValueCounts().size() != 5)
            return false;

        List<Card.CardValue> values = h.cardValuesSorted();

        return values.get(4).ordinal() - values.get(0).ordinal() == 4;
    }

    private static boolean isThreeOfAKind(Hand h) {
        Map<Card.CardValue, Long> valueCounts = h.cardValueCounts();

        if (valueCounts.size() != 3)
            return false;

        return valueCounts.containsValue(3L);
    }

    // ASSUMES: h is not a full house (i.e. test full house first).
    private static boolean isTwoPair(Hand h) {
        Map<Card.CardValue, Long> valueCounts = h.cardValueCounts();

        if (valueCounts.size() != 3)
            return false;

        return valueCounts.containsValue(2L);
    }

    private static boolean isPair(Hand h) {
        return h.cardValueCounts().size() == 4;
    }

    private boolean isHighCard(Hand h) {
        return true;
    }
}
