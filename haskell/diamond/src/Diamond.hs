module Diamond (diamond) where

import Data.Char (isUpper, ord)


-- Build the whole diamond based on given letter, c.
diamond :: Char -> Maybe [String]
diamond c 
    | (not . isUpper) c = Nothing
    | otherwise = Just $ upper ++ lower
    where upper = makeUpperTriangle c
          lower = reverse $ init upper


-- Build the top half of the diamond, including the middle line.          
makeUpperTriangle :: Char -> [String]
makeUpperTriangle c =
    map (makeLine c) ['A'..c]
  
    
-- Build one line of the diamond for the given letter, c, with
-- appropriate padding based on the 'largest' leter in the diamond.    
makeLine :: Char -> Char -> String
makeLine maxLetter c

    -- Base case: 'A' only appears once in the line.
    | c == 'A' = sidePadding ++ "A" ++ sidePadding

    -- Inductive step: 'larger' letters appear twice in the line.
    | otherwise = 
        sidePadding ++ [c] ++ midPadding ++ [c] ++ sidePadding
        
    where maxVal = alphaVal maxLetter
          sidePadding = replicate (maxVal - alphaVal c) ' '
          midPadding  = replicate (2 * alphaVal c - 3)  ' '


-- Returns the position in the alphabet of the uppercase character c
--  e.g.:   'A' -> 1
--          'B' -> 2
--          ...
--          'Z' -> 26
alphaVal :: Char -> Int
alphaVal c = ord c - 64
