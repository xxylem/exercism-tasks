module Clock (addDelta, fromHourMin, toString) where

type Minutes = Int
type Hours   = Int
data Clock = Clock {

        hours   :: Hours
    ,   minutes :: Minutes

    } deriving (Eq, Ord)

instance Show Clock where
    show Clock { hours = h
               , minutes = m } =
        (pad . show) h ++ ":" ++ (pad . show) m
        where pad str = replicate (2 - length str) '0' ++ str


fromHourMin :: Hours -> Minutes -> Clock
fromHourMin hour mins =
    Clock { hours = (hour + (mins `div` 60)) `mod` 24
          , minutes = mins `mod` 60 }


toString :: Clock -> String
toString = show


addDelta :: Hours -> Minutes -> Clock -> Clock
addDelta hour mins clock =
    fromHourMin (hour + hours clock)
                (mins + minutes clock)