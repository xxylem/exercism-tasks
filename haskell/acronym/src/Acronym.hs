{-# LANGUAGE OverloadedStrings #-}

module Acronym (abbreviate) where

import Data.Attoparsec.Text (Parser, parseOnly, many', skipSpace, 
                                endOfInput, skipWhile, inClass, letter)
import Data.Char            (isUpper, toUpper)
import Data.Either          (fromRight)
import Data.Text            (Text, pack)


abbreviate :: Text -> Text
abbreviate = fromRight "" . parseOnly parseAbbreviation


parseAbbreviation :: Parser Text
parseAbbreviation =     pack    
                    <$> many' wordChunk
                    <*  skipSpace
                    <*  endOfInput


wordChunk :: Parser Char
wordChunk =     -- Chunks may be preceded by any of these symbols.
                skipWhile (inClass " _,-") 
                -- Then get the first letter and make it uppercase if it isn't already.
            *>  (toUpper <$> letter)
                -- Ignore any capital letters that immmediately follow.
            <*  skipWhile isUpper
            <*  skipWhile (inClass "a-z'")
