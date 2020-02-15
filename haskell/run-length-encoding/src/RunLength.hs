module RunLength (decode, encode) where

import Control.Applicative ((<|>))
import Data.Attoparsec.Text (Parser, anyChar, decimal, endOfInput, many', parseOnly)
import Data.Either (fromRight)
import Data.List (group)
import Data.Text (pack)

data Group = Singleton Char
           | Repeat Int Char

instance Show Group where 
    show (Singleton c) = [c]
    show (Repeat n c) = replicate n c

decode :: String -> String
decode encodedText = concatMap show $ fromRight [] $
    parseOnly parseAllGroups $ pack encodedText

parseGroup :: Parser Group
parseGroup = 
        (Repeat <$> decimal <*> anyChar)
    <|> (Singleton <$> anyChar)

parseAllGroups :: Parser [Group]
parseAllGroups = do
    groups <- many' parseGroup
    _ <- endOfInput
    return groups

encode :: String -> String
encode text = concatMap f (group text)
    where f [] = []
          f [c] = [c]
          f grp@(c:_) = show (length grp) ++ [c]
