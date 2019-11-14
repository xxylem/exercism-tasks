module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance xs ys =
    if length xs == length ys 
    then Just $ sum $ zipWith (\c1 c2 -> if c1 == c2 then 0 else 1) 
                              xs ys
    else Nothing
