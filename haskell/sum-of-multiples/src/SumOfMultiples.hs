module SumOfMultiples (sumOfMultiples) where

import qualified Data.Set as S

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ S.unions $
    map multiplesOf factorsOnlyPositives
    where factorsOnlyPositives = filter (> 0) factors
          multiplesOf factor = S.fromDistinctAscList [factor, factor + factor..limit - 1]