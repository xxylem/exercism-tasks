package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.hash;

public class Card {

    public enum CardValue {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        private static CardValue toCardValue(String cv) {
            switch (cv) {
                case "A":
                    return ACE;
                case "2":
                    return TWO;
                case "3":
                    return THREE;
                case "4":
                    return FOUR;
                case "5":
                    return FIVE;
                case "6":
                    return SIX;
                case "7":
                    return SEVEN;
                case "8":
                    return EIGHT;
                case "9":
                    return NINE;
                case "10":
                    return TEN;
                case "J":
                    return JACK;
                case "Q":
                    return QUEEN;
                case "K":
                    return KING;
                default:
                    throw new IllegalArgumentException(String.format("Bad card value: %s", cv));
            }
        }
    }

    enum Suit {
        DIAMONDS, HEARTS, CLUBS, SPADES;

        private static Suit toSuit(String suit) {
            switch (suit) {
                case "D":
                    return DIAMONDS;
                case "H":
                    return HEARTS;
                case "C":
                    return CLUBS;
                case "S":
                    return SPADES;
                default:
                    throw new IllegalArgumentException(String.format("Bad suit: %s", suit));
            }
        }
    }

    private CardValue value;
    private Suit suit;
    private final String cardStringRep;

    Card(String card) {
        this.cardStringRep = card;
        parseCard();
    }

    private void parseCard() {
        Pattern p = Pattern.compile("^(?<value>A|[2-9]|10|J|Q|K)(?<suit>[DCSH])$");
        Matcher m = p.matcher(this.cardStringRep);

        if (m.find()) {
            this.value = CardValue.toCardValue(m.group("value"));
            this.suit = Suit.toSuit((m.group("suit")));
        }
        else
            throw new IllegalArgumentException(String.format("Bad card: %s", this.cardStringRep));
    }

    CardValue getValue() { return this.value; }
    Suit getSuit() { return this.suit; }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Card otherCard = (Card) o;
        // field comparison
        return this.suit == otherCard.suit
                && this.value == otherCard.value;
    }

    @Override
    public int hashCode() {
        return hash(this.value, this.suit);
    }
}
