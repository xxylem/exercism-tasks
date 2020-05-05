module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum 
    [x | x <- [1..limit - 1], isMultiple x]
    where factorsOnlyPositives = filter (> 0) factors
          isMultiple n = any (\factor -> n `mod` factor == 0) factorsOnlyPositives
            