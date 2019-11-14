module Queens (boardString, canAttack) where

import Control.Lens ((.~), (&), element)

boardString :: Maybe (Int, Int) -> Maybe (Int, Int) -> String
boardString Nothing         Nothing = 
    unlines emptyBoard
boardString (Just (x, y))   Nothing = 
    unlines . addWhiteQueen x y $ emptyBoard
boardString Nothing         (Just (x, y)) = 
    unlines . addBlackQueen x y $ emptyBoard
boardString (Just (x1, y1)) (Just (x2, y2)) = 
    unlines . addBlackQueen x2 y2 . addWhiteQueen x1 y1 $ emptyBoard 

addBlackQueen :: Int -> Int -> [String] -> [String]
addBlackQueen = addQueen 'B'

addWhiteQueen :: Int -> Int -> [String] -> [String]
addWhiteQueen = addQueen 'W'

addQueen :: Char -> Int -> Int -> [String] -> [String]
addQueen c x y board = board & element x . element (2 * y) .~ c

emptyBoard :: [String]
emptyBoard = 
    [ "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _"
    , "_ _ _ _ _ _ _ _" ]

canAttack :: (Int, Int) -> (Int, Int) -> Bool
canAttack (x1, y1) (x2, y2) =
       x1 == x2  -- same row
    || y1 == y2  -- same column
    || y1 - y2 == x1 - x2  -- same nw-se diagonal
    || x1 + y1 == x2 + y2  -- same ne-sw diagonal
