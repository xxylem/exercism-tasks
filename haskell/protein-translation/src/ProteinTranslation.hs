module ProteinTranslation(proteins) where

import Data.List.Split (chunksOf)
import Text.Read       (readMaybe)

data Codon =
      AUG 
    | UUU | UUC 
    | UUA | UUG
    | UCU | UCC | UCA | UCG 
    | UAU | UAC 
    | UGU | UGC 
    | UGG 
    | UAA | UAG | UGA
    deriving (Read, Show)

data Protein =
      Methionine
    | Phenylalanine
    | Leucine
    | Serine
    | Tyrosine
    | Cysteine
    | Tryptophan
    | STOP
    deriving (Eq, Show)

-- ASSUMES: Any parse failure after the STOP codon is to be ignored.
proteins :: String -> Maybe [String]
proteins = (fmap . fmap) show 
    . sequence 
    . takeWhile (/= Just STOP)
    . fmap (fmap translateCodon . readMaybe)
    . chunksOf 3

translateCodon :: Codon -> Protein
translateCodon c =
    case c of
        AUG -> Methionine

        UUU -> Phenylalanine
        UUC -> Phenylalanine

        UUA -> Leucine
        UUG -> Leucine

        UCU -> Serine
        UCC -> Serine
        UCA -> Serine
        UCG -> Serine

        UAU -> Tyrosine
        UAC -> Tyrosine

        UGU -> Cysteine
        UGC -> Cysteine

        UGG -> Tryptophan

        UAA -> STOP
        UAG -> STOP
        UGA -> STOP