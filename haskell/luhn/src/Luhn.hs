module Luhn (isValid) where

import Data.Char (digitToInt, isDigit)

isValid :: String -> Bool
isValid n =
    let preprocessedNumber = filter isDigit n in
        length preprocessedNumber > 1 
    &&  checksum preprocessedNumber `mod` 10 == 0

-- ASSUMES: Input number only contains digits (in Char representation).
checksum :: String -> Int
checksum n = 
    go n (even $ length n)
    where go [] _ = 0
          go (dChar:ds) double = 
            let d = digitToInt dChar
                dd = 2 * d
                dd' = if dd > 9 then dd - 9 else dd in
            (if double then dd' else d)
            + go ds (not double)