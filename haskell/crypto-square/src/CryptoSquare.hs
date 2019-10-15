module CryptoSquare (encode) where

import           Data.Char        (isAlphaNum, toLower)
import           Data.Matrix      (Matrix)
import qualified Data.Matrix as M
import qualified Data.Vector as V (toList)

-- Encode the message using the "CryptoSquare" system.
encode :: String -> String
encode message =

        -- Make 'chunks' from the columns
        unwords 
        -- Get the columns from the matrix
    $   columnsToList 
        -- Make a matrix from the message
    $   M.fromList rows cols paddedMessage

    where   preProcessedMessage = (map toLower . filter isAlphaNum) message
            paddedMessage = preProcessedMessage ++ repeat ' '
            (cols, rows) = (getDimensions . length) preProcessedMessage


-- Returns a list of the columns of the matrix m starting
--  from column 1.
columnsToList :: Matrix Char -> [String]
columnsToList m = V.toList <$> go totalCols
    
    where   totalCols = M.ncols m
            go 0 = []
            go n = M.getCol (totalCols + 1 - n) m : go (n - 1)


-- Returns positive integers c and r 
--      s.t. c*r >= n and c - r <= 1
getDimensions :: Int -> (Int, Int)
getDimensions n = (c, r)

    where   c = (ceiling . (sqrt :: Double -> Double) . fromIntegral) n
            r = ceiling (fromIntegral n / fromIntegral c :: Double)
