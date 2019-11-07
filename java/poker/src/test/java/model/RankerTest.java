package model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static model.Ranker.computeRank;

public class RankerTest {

    @Test
    public void testStraightFlush() {
        Hand h = new Hand("7H 9H JH 8H 10H");
        Rank r = computeRank(h);

        assertEquals(r, Rank.STRAIGHT_FLUSH);
    }

    @Test
    public void testFourOfAKind() {
        Hand h = new Hand("3D 7D 3S 3H 3C");
        Rank r = computeRank(h);

        assertEquals(r, Rank.FOUR_OF_A_KIND);
    }

    @Test
    public void testFullHouse() {
        Hand h = new Hand("KD 7H 7S KH KC");
        Rank r = computeRank(h);

        assertEquals(r, Rank.FULL_HOUSE);
    }

    @Test
    public void testFlush() {
        Hand h = new Hand("7S 10S JS 2S 4S");
        Rank r = computeRank(h);

        assertEquals(r, Rank.FLUSH);
    }

    @Test
    public void testStraight() {
        Hand h = new Hand("4S 5H 3S 2D 6H");
        Rank r = computeRank(h);

        assertEquals(r, Rank.STRAIGHT);
    }

    @Test
    public void testThreeOfAKind() {
        Hand h = new Hand("6D 8C 2S 6H 6C");
        Rank r = computeRank(h);

        assertEquals(r, Rank.THREE_OF_A_KIND);
    }

    @Test
    public void testTwoPair() {
        Hand h = new Hand("4S 4C 6H 8D 8S");
        Rank r = computeRank(h);

        assertEquals(r, Rank.TWO_PAIR);
    }

    @Test
    public void testPair() {
        Hand h = new Hand("2C 4S 9H QS QC");
        Rank r = computeRank(h);

        assertEquals(r, Rank.PAIR);
    }

    @Test
    public void testHighCard() {
        Hand h = new Hand("AS 4H QD 7C 8S");
        Rank r = computeRank(h);

        assertEquals(r, Rank.HIGH_CARD);
    }
}
