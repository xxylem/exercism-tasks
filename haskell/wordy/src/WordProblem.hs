{-# LANGUAGE OverloadedStrings #-}

module WordProblem (answer) where

import Control.Applicative  ((<|>))
import Data.Attoparsec.Text (Parser, char, decimal, endOfInput, 
                             many', parseOnly, signed, skipSpace)
import Data.Text            (pack)

answer :: String -> Maybe Integer
answer problem = case parseOnly parseQuestion (pack problem) of
    Right question -> Just (compute question)
    Left  _ -> Nothing

data Question =
    Question Integer [Operation]
    deriving (Eq, Show)

data Operation =
      Plus Integer
    | Minus Integer
    | Multiply Integer
    | Divide Integer
    deriving (Eq, Show)

parseQuestion :: Parser Question
parseQuestion = do
    _           <- "What is "
    firstNumber <- signed decimal
    operations  <- many' parseOperation
    _           <- char '?'
    _           <- endOfInput
    return $ Question firstNumber operations

compute :: Question -> Integer
compute (Question firstNumber ops) =
    foldl   (\rsf op -> case op of
                Plus n     -> rsf + n
                Minus n    -> rsf - n
                Multiply n -> rsf * n
                Divide n   -> rsf `div` n)
            firstNumber
            ops

parseOperation :: Parser Operation
parseOperation =
        skipSpace
    *> (parsePlus
    <|> parseMinus
    <|> parseMultiply
    <|> parseDivide)

parsePlus :: Parser Operation
parsePlus = "plus " 
    *> (Plus <$> signed decimal)

parseMinus :: Parser Operation
parseMinus = "minus " 
    *> (Minus <$> signed decimal)

parseMultiply :: Parser Operation
parseMultiply = "multiplied by " 
    *> (Multiply <$> signed decimal)

parseDivide :: Parser Operation
parseDivide = "divided by " 
    *> (Divide <$> signed decimal)
