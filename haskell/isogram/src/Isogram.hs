module Isogram (isIsogram) where

import           Data.Char          (isAlpha, toLower)
import qualified Data.Set   as S


isIsogram :: String -> Bool
isIsogram str =
    length ls == S.size (S.fromList ls)
    where ls = toLower <$> filter isAlpha str
