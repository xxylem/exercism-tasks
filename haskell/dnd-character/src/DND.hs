module DND ( Character(..)
           , ability
           , modifier
           , character
           ) where

import Data.List (sortBy)
import Test.QuickCheck (Gen, choose)

data Character = Character
  { strength     :: Int
  , dexterity    :: Int
  , constitution :: Int
  , intelligence :: Int
  , wisdom       :: Int
  , charisma     :: Int
  , hitpoints    :: Int
  }
  deriving (Show, Eq)

modifier :: Int -> Int
modifier c =
  (c - 10) `div` 2
  
ability :: Gen Int
ability = do
  d1 <- dice
  d2 <- dice 
  d3 <- dice
  d4 <- dice
  return $ sum . take 3 . sortBy (flip compare) $ [d1, d2, d3, d4]
  where dice = choose (1, 6)

character :: Gen Character
character = do
  str <- ability
  dex <- ability
  con <- ability
  int <- ability
  wis <- ability
  cha <- ability
  
  return Character {
    strength = str,
    dexterity = dex,
    constitution = con,
    intelligence = int,
    wisdom = wis,
    charisma = cha,
    hitpoints = 10 + modifier con
  }