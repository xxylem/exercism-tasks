module Triangle (rows) where

-- ASSUMES: n >= 0
rows :: Int -> [[Integer]]
rows 0 = []
rows 1 = [[1]]
rows n = restOfTriangle ++ [newRow]
    where restOfTriangle = rows (n - 1)
          lastRow = last restOfTriangle  -- Nonempty due to base case n=1
          newRow = zipWith (+) (lastRow++[0]) (0:lastRow)
