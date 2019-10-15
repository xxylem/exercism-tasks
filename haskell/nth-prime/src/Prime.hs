module Prime (nth) where

import Prelude hiding (gcd) 
-- Problem statement forbids prime-related library functions.

nth :: Int -> Maybe Integer
nth 0 = Nothing
nth n = Just $ primes !! n


primes :: [Integer]
primes = filter isPrime [1..]

isPrime :: Integer -> Bool
isPrime n =
    and [ n `relativelyPrimeTo` x | x <- [2..n-1]]

relativelyPrimeTo :: Integer -> Integer -> Bool
relativelyPrimeTo a b =
    gcd a b == 1

gcd :: Integer -> Integer -> Integer
gcd a 0 = a
gcd a b = gcd b $ a `rem` b