module CollatzConjecture (collatz) where

collatz :: Integer -> Maybe Integer
collatz n
    | n <  1    = Nothing
    | otherwise = go 0 n
    where go steps 1 = Just steps
          go steps n' = go (succ steps) (if even n' then n' `div` 2 else 3 * n' + 1)
