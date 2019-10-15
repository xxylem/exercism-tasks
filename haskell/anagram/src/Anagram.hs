module Anagram (anagramsFor) where

import           Data.List            (permutations)
import           Data.Set             (Set)
import qualified Data.Set             as S
import qualified Data.CaseInsensitive as CI

-- Returns those candidates which are valid anagrams for
--  the given subject.
anagramsFor :: String -> [String] -> Set String
anagramsFor subject candidates =
        S.map CI.original 
    $   S.delete (CI.mk subject)
    $   S.intersection 
                (S.fromList (CI.mk <$> candidates))
                (S.fromList (CI.mk <$> permutations subject))
