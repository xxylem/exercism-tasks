package model;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

    private final String cardsStringRep;
    private List<Card> cards;
    private Rank rank;

    Hand(String cards) {
        this.cardsStringRep = cards;
        parseCards();
        validateHand();
    }

    public Rank getRank() {
        if (this.rank == null)
            this.rank = Ranker.computeRank(this);
        return this.rank;
    }

    private void parseCards() {
        this.cards = Arrays.stream(this.cardsStringRep.split(" "))
                .map(Card::new)
                .collect(Collectors.toList());
    }

    private void validateHand() {
        if (cards.size() != 5)
            throw new IllegalArgumentException(
                    String.format("Invalid hand size. Given %d cards, expected 5.",
                            this.cards.size()));

        Set<Card> tempSet = new HashSet<>(this.cards);
        if (this.cards.size() != tempSet.size())
            throw new IllegalArgumentException(
                    "Duplicate cards in hand.");
    }

    @Override
    public String toString() {
        return cardsStringRep;
    }

    public Map<Card.CardValue, Long> cardValueCounts() {
        // TODO only compute once and only when requested
        return this.cards.stream().map(Card::getValue).collect(Collectors.groupingBy(x->x, Collectors.counting()));
    }

    public List<Card.CardValue> cardValuesSorted() {
        return this.cards.stream().map(Card::getValue).sorted().collect(Collectors.toList());
    }

    public Map<Card.Suit, Long> cardSuitCounts() {
        // TODO only compute once and only when requested
        return this.cards.stream().map(Card::getSuit).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.getRank() != hand.getRank())
            return this.getRank().compareTo(hand.getRank());

        else
            return this.getRank().compareHandsWithSameRank(this, hand);
    }
}
