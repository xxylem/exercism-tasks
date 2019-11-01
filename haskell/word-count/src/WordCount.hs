module WordCount (wordCount) where

import           Data.Char (isAlphaNum, toLower)
import           Data.List.Split (wordsBy)
import           Data.Map.Strict (Map)
import qualified Data.Map.Strict as Map

wordCount :: String -> Map String Int
wordCount xs =
    foldl (\m w ->
        Map.insertWith (+) (stripQuotes $ map toLower w) 1 m)
    Map.empty   
    (wordsBy (\c -> not (isAlphaNum c || c == '\'')) xs)

-- ASSUMES: The given word has balanced surrounding quotes or none.
stripQuotes :: String -> String
stripQuotes [] = []
stripQuotes (x:xs) =
    case x of
    '\'' -> init xs
    _ -> x:xs


