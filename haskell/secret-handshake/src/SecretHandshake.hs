module SecretHandshake (handshake) where

import Data.Bits ((.&.))

actions :: [(Int, String)]
actions = [ (8, "jump")
          , (4, "close your eyes")
          , (2, "double blink")
          , (1, "wink") ]

handshake :: Int -> [String]
handshake n =
    (if n .&. 16 /= 0 then reverse else id) $
    foldl (\acc (m, str) -> 
                if n .&. m /= 0 then str:acc else acc)
          []
          actions




