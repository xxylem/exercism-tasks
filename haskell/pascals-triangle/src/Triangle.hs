module Triangle (rows) where

rows :: Int -> [[Integer]]
rows n = take n $ iterate nextRow [1]
    where nextRow prevRow = zipWith (+) (prevRow++[0]) (0:prevRow)
