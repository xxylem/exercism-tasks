module CryptoSquare (encode) where

import Data.Char (isAlphaNum, toLower)
import Data.Matrix (Matrix)
import qualified Data.Matrix as M
import qualified Data.Vector as V (toList)

encode :: String -> String
encode message =
    unwords $
    toList $
    M.fromList r c paddedMessage
    where preProcessedMessage = map toLower $ filter isAlphaNum message
          len = length preProcessedMessage
          c = (ceiling . sqrt . fromIntegral) len
          r = ceiling $ fromIntegral len / fromIntegral c
          paddedMessage = preProcessedMessage ++ repeat ' '

toList :: Matrix Char -> [String]
toList m =
    V.toList <$> go totalCols
    where totalCols = M.ncols m
          go 0 = []
          go n = M.getCol (totalCols + 1 - n) m : go (n - 1)
