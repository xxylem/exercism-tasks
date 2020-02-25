module DNA (toRNA) where

toRNA :: String -> Either Char String
toRNA = mapM translateNucleotide

translateNucleotide :: Char -> Either Char Char
translateNucleotide n = case n of
    'G' -> Right 'C'
    'C' -> Right 'G'
    'T' -> Right 'A'
    'A' -> Right 'U'
    _   -> Left  n