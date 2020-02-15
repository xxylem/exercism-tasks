{-# LANGUAGE NumDecimals #-}

module ResistorColors (Color(..), Resistor(..), label, ohms) where

data Color =
    Black
  | Brown
  | Red
  | Orange
  | Yellow
  | Green
  | Blue
  | Violet
  | Grey
  | White
  deriving (Show, Enum, Bounded)

newtype Resistor = Resistor { bands :: (Color, Color, Color) }
  deriving Show
  
bandValue :: Color -> Int
bandValue c = case c of
  Black   -> 0
  Brown   -> 1
  Red     -> 2
  Orange  -> 3
  Yellow  -> 4
  Green   -> 5
  Blue    -> 6
  Violet  -> 7
  Grey    -> 8
  White   -> 9

label :: Resistor -> String
label resistor
  | o >= 1e9 = divShow o 1e9 ++ " gigaohms"
  | o >= 1e6 = divShow o 1e6 ++ " megaohms"
  | o >= 1e3 = divShow o 1e3 ++ " kiloohms"
  | otherwise = show o ++ " ohms"
  where o = ohms resistor
        -- To handle the extra test cases involving decimal points in the scientific notation.
        divShow d n =
          let (dDivN, dModN) = d `divMod` n in
            if dModN == 0
              then show dDivN
              -- Presumably we would want to limit the number of decimal places in the output but this
                -- is enough to handle the given test cases.
              else show $ fromIntegral d / (fromIntegral n :: Double)

ohms :: Resistor -> Int
ohms Resistor{bands = (b1, b2, b3)} = 
  (10 * bandValue b1 + bandValue b2) * 10 ^ bandValue b3
