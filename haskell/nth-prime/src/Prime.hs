module Prime (nth) where

-- Returns the nth prime if n is a natural number or 
-- Nothing if n is not.
nth :: Int -> Maybe Integer
nth n
    | n < 1     = Nothing
    | n == 1    = Just 2
    | otherwise =
        go [2] [3, 5..] (n - 1)
        where
            -- ghc complains about non-exhaustive pattern match here
            -- but it is not a problem since there are infinite candidates
            go primesFound (c:candidates) m 
                | isPrime = 
                    if m == 1 
                    then Just c
                    else go (c:primesFound) candidates (m-1)
                | otherwise = go primesFound candidates m
                where isPrime =
                        all (\p -> c `mod` p /= 0) primesFound
            