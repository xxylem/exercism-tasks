module DNA (nucleotideCounts, Nucleotide(..)) where

import           Data.Map (Map)
import qualified Data.Map as M

data Nucleotide = A | C | G | T deriving (Eq, Ord, Show)

nucleotideCounts :: String -> Either String (Map Nucleotide Int)
nucleotideCounts xs = foldr (M.adjust succ) emptyCounts 
    <$> mapM toNucleotide xs

emptyCounts :: Map Nucleotide Int
emptyCounts = M.fromList [ (A, 0), 
                           (C, 0), 
                           (G, 0), 
                           (T, 0) ]

toNucleotide :: Char -> Either String Nucleotide
toNucleotide 'A' = Right A
toNucleotide 'C' = Right C
toNucleotide 'G' = Right G
toNucleotide 'T' = Right T
toNucleotide c   = Left $ "Bad char in input: " ++ [c]