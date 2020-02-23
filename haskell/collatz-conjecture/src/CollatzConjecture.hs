module CollatzConjecture (collatz) where

collatz :: Integer -> Maybe Integer
collatz n
    | n <  1    = Nothing
    | n == 1    = Just 0
    | even n    = succ <$> collatz (n `div` 2)
    | otherwise = succ <$> collatz (3 * n + 1)
        
