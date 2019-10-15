module PerfectNumbers (classify, Classification(..)) where

data Classification = Deficient | Perfect | Abundant deriving (Eq, Show)


classify :: Int -> Maybe Classification
classify x 
    | x <= 0 = Nothing
    | otherwise = Just $ case compare (sum (factorsOf x)) x of
                            GT -> Abundant
                            EQ -> Perfect
                            LT -> Deficient


factorsOf :: Int -> [Int]
factorsOf n = [x | x <- [1..n `div` 2], n `mod` x == 0]
