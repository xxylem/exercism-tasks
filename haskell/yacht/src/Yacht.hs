module Yacht (yacht, Category(..)) where

import Data.List (group, sort)

data Category = Ones
              | Twos
              | Threes
              | Fours
              | Fives
              | Sixes
              | FullHouse
              | FourOfAKind
              | LittleStraight
              | BigStraight
              | Choice
              | Yacht

yacht :: Category -> [Int] -> Int
yacht c dice = case c of
    Ones            -> numbers 1 dice
    Twos            -> numbers 2 dice
    Threes          -> numbers 3 dice
    Fours           -> numbers 4 dice
    Fives           -> numbers 5 dice
    Sixes           -> numbers 6 dice
    FullHouse       -> fullHouseScore dice
    FourOfAKind     -> fourOfAKindScore dice
    LittleStraight  -> if sort dice == [1, 2, 3, 4, 5] then 30 else 0
    BigStraight     -> if sort dice == [2, 3, 4, 5, 6] then 30 else 0
    Choice          -> sum dice
    Yacht           -> if length (group dice) == 1 then 50 else 0
    where numbers n = sum . filter (== n)

fullHouseScore :: [Int] -> Int
fullHouseScore dice = if length dice == 5
    && length grp == 2
    && ((length (head grp) == 3) || length (head grp) == 2)
    then sum dice else 0
    where grp = group . sort $ dice

fourOfAKindScore :: [Int] -> Int
fourOfAKindScore dice 
    | head sortedDice == sortedDice !! 3 = 
        sum . init $ sortedDice
    | sortedDice !! 1 == sortedDice !! 4 =
        sum . tail $ sortedDice
    | otherwise = 0
    where sortedDice = sort dice