module Phone (number) where

import           Control.Applicative  ((<|>))
import           Data.Attoparsec.Text (Parser, char, count, digit, 
                                        endOfInput, option, parseOnly, 
                                        satisfy, skip, skipSpace)
import qualified Data.Text as T       (pack)

number :: String -> Maybe String
number = toMaybe . parseOnly phoneNumber . T.pack
    where toMaybe (Right a) = Just a
          toMaybe _ = Nothing 

phoneNumber :: Parser String
phoneNumber = do
    _ <- skipSpace *> skipCountryCode *> skipSpace

    area <- areaCode

    _ <- skipSpace *> skipHyphenOrDotOption *> skipSpace

    exchange <- exchangeCode

    _ <- skipSpace *> skipHyphenOrDotOption *> skipSpace

    subscriber <- subscriberCode

    _ <- skipSpace *> endOfInput

    return (area ++ exchange ++ subscriber)


skipCountryCode :: Parser ()
skipCountryCode = 
    option  () 
            (option () (skip (== '+')) *> skip (== '1')) 

areaCode :: Parser String
areaCode = 
    -- Either both brackets or none.
        (do _ <- char '('
            n <- digit2to9
            xx <- count 2 digit
            _ <- char ')'
            return (n:xx))

    <|> (do n <- digit2to9
            xx <- count 2 digit
            return (n:xx))

exchangeCode :: Parser String
exchangeCode = do
    n <- digit2to9
    xx <- count 2 digit
    return (n:xx)

subscriberCode :: Parser String
subscriberCode = count 4 digit

skipHyphenOrDotOption :: Parser ()
skipHyphenOrDotOption = option () (skip (=='.') <|> skip (=='-'))

digit2to9 :: Parser Char
digit2to9 = satisfy (\c -> c >= '2' && c <= '9')