module OCR (convert) where

type Row = [String]

convert :: String -> String
convert xs = undefined

toRows :: [String] -> [Row]
toRows input =
    go input []
    where go [] rsf = rsf
          go (r:rs) ([currentRow]:rest) =
            if any (\= ' ') r
            then go rs ([r:currentRow]:rest)
            else go rs ([r]:currentRow:rest)

splitRow :: Row -> [String]
splitRow = 