module PokerHand where

-- We don't need the suit
data Rank =
    Two
    | Three
    | Four
    | Five
    | Six
    | Seven
    | Eight
    | Nine
    | Ten
    | Jack
    | Queen
    | King
    | Ace
    deriving (Eq, Ord, Show)

data PokerHand =
      StraightFlush Integer
    | FourOfAKind Integer Integer
    | FullHouse Integer Integer
    | Flush Integer Integer Integer Integer Integer
    | Straight Integer
    | ThreeOfAKind Integer Integer Integer
    | TwoPair Integer Integer Integer
    | OnePair Integer Integer Integer Integer
    | HighCard Integer Integer Integer Integer Integer