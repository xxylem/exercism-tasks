package model;

import java.util.List;

public enum Rank {

    HIGH_CARD {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            List<Card.CardValue> values1 = h1.cardValuesSorted();
            List<Card.CardValue> values2 = h2.cardValuesSorted();

            for (int i = 0; i < 5; i++) {
                int diff = values1.get(i).compareTo(values2.get(i));
                if (diff != 0)
                    return diff;
            }

            return 0;
        }
    }, PAIR {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, TWO_PAIR {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, THREE_OF_A_KIND {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, STRAIGHT {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
            }
    }, FLUSH {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, FULL_HOUSE {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, FOUR_OF_A_KIND {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    }, STRAIGHT_FLUSH {
        public int compareHandsWithSameRank(Hand h1, Hand h2) {
            return 0;
        }
    };

    public abstract int compareHandsWithSameRank(Hand hand, Hand hand1);
}
