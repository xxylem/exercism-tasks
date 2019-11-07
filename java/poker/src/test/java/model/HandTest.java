package model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HandTest {

    private Hand straightFlush;
    private Hand fourOfAKind;
    private Hand fullHouse;
    private Hand flush;
    private Hand straight;
    private Hand threeOfAKind;
    private Hand twoPair;
    private Hand pair;
    private Hand highCard;

    @Before
    public void setup() {
        straightFlush = new Hand("7H 9H JH 8H 10H");
        fourOfAKind = new Hand("3D 7D 3S 3H 3C");
        fullHouse = new Hand("KD 7H 7S KH KC");
        flush = new Hand("7S 10S JS 2S 4S");
        straight = new Hand("4S 5H 3S 2D 6H");
        threeOfAKind = new Hand("6D 8C 2S 6H 6C");
        twoPair = new Hand("4S 4C 6H 8D 8S");
        pair = new Hand("2C 4S 9H QS QC");
        highCard = new Hand("AS 4H QD 7C 8S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateFailsEmptyHand() {
       new Hand("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateFailsTooFewCards() {
        new Hand("4S 5S 7H 8D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateFailsTooManyCards() {
        new Hand("3S 3H 2S 3D 3C JC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateFailsDuplicateCard() {
        new Hand("4S 5S 7H 8D 8D");
    }

    @Test
    public void testCardValuesAllDifferent() {
        Hand h = new Hand("4S 5S 7H 8D JC");
        Map<Card.CardValue, Long> expected = new HashMap<>();
        expected.put(Card.CardValue.FOUR, 1L);
        expected.put(Card.CardValue.FIVE, 1L);
        expected.put(Card.CardValue.SEVEN, 1L);
        expected.put(Card.CardValue.EIGHT, 1L);
        expected.put(Card.CardValue.JACK, 1L);
        assertEquals(h.cardValueCounts(), expected);
    }

    @Test
    public void testCardValuesTwoSame() {
        Hand h = new Hand("2S 4H 6S 4D JH");
        Map<Card.CardValue, Long> expected = new HashMap<>();
        expected.put(Card.CardValue.FOUR, 2L);
        expected.put(Card.CardValue.TWO, 1L);
        expected.put(Card.CardValue.SIX, 1L);
        expected.put(Card.CardValue.JACK, 1L);
        assertEquals(h.cardValueCounts(), expected);
    }

    @Test
    public void testCardValuesThreeSame() {
        Hand h = new Hand( "4S 5H 4C 8S 4H");
        Map<Card.CardValue, Long> expected = new HashMap<>();
        expected.put(Card.CardValue.FOUR, 3L);
        expected.put(Card.CardValue.FIVE, 1L);
        expected.put(Card.CardValue.EIGHT, 1L);
        assertEquals(h.cardValueCounts(), expected);
    }

    @Test
    public void testCardValuesFourSame() {
        Hand h = new Hand( "3S 3H 2S 3D 3C");
        Map<Card.CardValue, Long> expected = new HashMap<>();
        expected.put(Card.CardValue.THREE, 4L);
        expected.put(Card.CardValue.TWO, 1L);
        assertEquals(h.cardValueCounts(), expected);
    }

    @Test
    public void testAHandIsEqualToItself() {
        assertEquals(0, straightFlush.compareTo(straightFlush));
        assertEquals(0, fullHouse.compareTo(fullHouse));
        assertEquals(0, flush.compareTo(flush));
        assertEquals(0, straight.compareTo(straight));
        assertEquals(0, threeOfAKind.compareTo(threeOfAKind));
        assertEquals(0, twoPair.compareTo(twoPair));
        assertEquals(0, pair.compareTo(pair));
        assertEquals(0, highCard.compareTo(highCard));
    }

    @Test
    public void testHandsWithDifferentRanks() {

        assertTrue(straightFlush.compareTo(fourOfAKind) > 0);
        assertTrue(straightFlush.compareTo(fullHouse) > 0);
        assertTrue(straightFlush.compareTo(flush) > 0);
        assertTrue(straightFlush.compareTo(straight) > 0);
        assertTrue(straightFlush.compareTo(threeOfAKind) > 0);
        assertTrue(straightFlush.compareTo(twoPair) > 0);
        assertTrue(straightFlush.compareTo(pair) > 0);
        assertTrue(straightFlush.compareTo(highCard) > 0);

        assertTrue(fourOfAKind.compareTo(straightFlush) < 0);
        assertTrue(fourOfAKind.compareTo(fullHouse) > 0);
        assertTrue(fourOfAKind.compareTo(flush) > 0);
        assertTrue(fourOfAKind.compareTo(straight) > 0);
        assertTrue(fourOfAKind.compareTo(threeOfAKind) > 0);
        assertTrue(fourOfAKind.compareTo(twoPair) > 0);
        assertTrue(fourOfAKind.compareTo(pair) > 0);
        assertTrue(fourOfAKind.compareTo(highCard) > 0);

        assertTrue(fullHouse.compareTo(straightFlush) < 0);
        assertTrue(fullHouse.compareTo(fourOfAKind) < 0);
        assertTrue(fullHouse.compareTo(flush) > 0);
        assertTrue(fullHouse.compareTo(straight) > 0);
        assertTrue(fullHouse.compareTo(threeOfAKind) > 0);
        assertTrue(fullHouse.compareTo(twoPair) > 0);
        assertTrue(fullHouse.compareTo(pair) > 0);
        assertTrue(fullHouse.compareTo(highCard) > 0);

        assertTrue(straight.compareTo(straightFlush) < 0);
        assertTrue(straight.compareTo(fourOfAKind) < 0);
        assertTrue(straight.compareTo(fullHouse) < 0);
        assertTrue(straight.compareTo(flush) < 0);
        assertTrue(straight.compareTo(threeOfAKind) > 0);
        assertTrue(straight.compareTo(twoPair) > 0);
        assertTrue(straight.compareTo(pair) > 0);
        assertTrue(straight.compareTo(highCard) > 0);

        assertTrue(threeOfAKind.compareTo(straightFlush) < 0);
        assertTrue(threeOfAKind.compareTo(fourOfAKind) < 0);
        assertTrue(threeOfAKind.compareTo(fullHouse) < 0);
        assertTrue(threeOfAKind.compareTo(flush) < 0);
        assertTrue(threeOfAKind.compareTo(straight) < 0);
        assertTrue(threeOfAKind.compareTo(twoPair) > 0);
        assertTrue(threeOfAKind.compareTo(pair) > 0);
        assertTrue(threeOfAKind.compareTo(highCard) > 0);

        assertTrue(twoPair.compareTo(straightFlush) < 0);
        assertTrue(twoPair.compareTo(fourOfAKind) < 0);
        assertTrue(twoPair.compareTo(fullHouse) < 0);
        assertTrue(twoPair.compareTo(flush) < 0);
        assertTrue(twoPair.compareTo(straight) < 0);
        assertTrue(twoPair.compareTo(threeOfAKind) < 0);
        assertTrue(twoPair.compareTo(pair) > 0);
        assertTrue(twoPair.compareTo(highCard) > 0);

        assertTrue(pair.compareTo(straightFlush) < 0);
        assertTrue(pair.compareTo(fourOfAKind) < 0);
        assertTrue(pair.compareTo(fullHouse) < 0);
        assertTrue(pair.compareTo(flush) < 0);
        assertTrue(pair.compareTo(straight) < 0);
        assertTrue(pair.compareTo(threeOfAKind) < 0);
        assertTrue(pair.compareTo(twoPair) < 0);
        assertTrue(pair.compareTo(highCard) > 0);

        assertTrue(highCard.compareTo(straightFlush) < 0);
        assertTrue(highCard.compareTo(fourOfAKind) < 0);
        assertTrue(highCard.compareTo(fullHouse) < 0);
        assertTrue(highCard.compareTo(flush) < 0);
        assertTrue(highCard.compareTo(straight) < 0);
        assertTrue(highCard.compareTo(threeOfAKind) < 0);
        assertTrue(highCard.compareTo(twoPair) < 0);
        assertTrue(highCard.compareTo(pair) < 0);
    }

    @Test
    public void compareHighCardsHighestDifferent() {
        Hand higher = new Hand("AS 7C 5D 9H 2S");
        Hand lower = new Hand("KS 7C 5D 9H 2S");

        assertTrue(higher.compareTo(lower) > 0);
    }
}