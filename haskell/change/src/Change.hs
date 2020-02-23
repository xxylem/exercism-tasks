module Change (findFewestCoins) where

import Data.List (subsequences, sortBy)
import Data.Maybe (catMaybes)
import Data.Ord (comparing)
import Safe.Foldable (minimumByMay)

findFewestCoins :: Integer -> [Integer] -> Maybe [Integer]
findFewestCoins target coins = minimumByMay (comparing length)
        $   catMaybes 
        $   greedySearchSubsequence target 
        <$> subsequences (sortDescending coins)
        where sortDescending = sortBy (flip compare)

greedySearchSubsequence :: Integer -> [Integer] -> Maybe [Integer]
greedySearchSubsequence 0 _ = Just []  
    -- Target hit exactly, no more coins needed to contribute.
greedySearchSubsequence _ [] = Nothing 
    -- No coins left that satisfy target. Branch is not valid
greedySearchSubsequence currentTarget coins@(c:cs) = 
    if c > currentTarget
    then greedySearchSubsequence currentTarget cs
        -- Current coin too big, so try smaller coins.
    else case greedySearchSubsequence (currentTarget - c) coins of
        ans@(Just _) -> (c:) <$> ans
            -- Found valid sequence of coins so add this coin on.
        _ -> greedySearchSubsequence currentTarget cs
            -- Didn't find valid sequence, so try smaller coins.