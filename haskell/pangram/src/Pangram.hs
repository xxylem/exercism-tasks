module Pangram (isPangram) where

import           Data.Char (toLower)
import qualified Data.Set as S

isPangram :: String -> Bool
isPangram text = S.null $
    S.fromAscList ['a'..'z']
        `S.difference`
    S.fromList (map toLower text)
