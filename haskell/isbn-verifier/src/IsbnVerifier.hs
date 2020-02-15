module IsbnVerifier (isbn) where

import Data.Char (isDigit, digitToInt)

isbn :: String -> Bool
isbn s = length sISBN == 10
      && all isDigit (init sISBN)
      && checksum sISBN `mod` 11 == 0
      where sISBN = sanitiseISBN s

sanitiseISBN :: String -> String
sanitiseISBN = filter (\c -> isDigit c || c == 'X')

-- Assumes ISBN has already been sanitised and checked for valid characters.
checksum :: String -> Int
checksum s = sum $
    zipWith (*)
        (map (\c -> if isDigit c then digitToInt c else 10) s)
        [10, 9..1]
    