module Prime (nth) where

import Prelude hiding (gcd) 
-- Problem statement forbids prime-related library functions.

nth :: Int -> Maybe Integer
nth 0 = Nothing
nth n = Just $ primes !! n


primes :: [Integer]
primes = filter isPrime [1..]

-- TODO this works but is very slow. 
-- Leverage the already-computed primes:
    -- We know:
        -- If n divides any primes < n, n is not prime
        -- So we can disregards all multiples of
            -- 2
            -- 3
            -- 5
            -- etc
        -- once we know that they are primes.
isPrime :: Integer -> Bool
isPrime n =
    and [ n `relativelyPrimeTo` x | x <- [2..n-1]]

relativelyPrimeTo :: Integer -> Integer -> Bool
relativelyPrimeTo a b =
    gcd a b == 1

gcd :: Integer -> Integer -> Integer
gcd a 0 = a
gcd a b = gcd b $ a `rem` b