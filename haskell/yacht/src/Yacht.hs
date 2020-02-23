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
fullHouseScore dice = case group . sort $ dice of
    [[_,_,_],[_,_]] -> sum dice
    [[_,_],[_,_,_]] -> sum dice
    _               -> 0

fourOfAKindScore :: [Int] -> Int
fourOfAKindScore dice = case group . sort $ dice of
    [[_,_,_,_,x]]      -> sum dice - x
    [d@[_,_,_,_], [_]] -> sum d
    [[_], d@[_,_,_,_]] -> sum d
    _                  -> 0