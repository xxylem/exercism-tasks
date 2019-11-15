module Robot
    ( Bearing(East,North,South,West)
    , bearing
    , coordinates
    , mkRobot
    , move
    ) where

data Bearing = North
             | East
             | South
             | West
             deriving (Eq, Show)

type Point = (Integer, Integer)
data Robot = Robot { bearing  :: Bearing
                   , coordinates :: Point }

-- Provided for compatibility with test suite.
-- Normally the Robot constructor would suffice.
mkRobot :: Bearing -> Point -> Robot
mkRobot = Robot

rotateLeft :: Robot -> Robot
rotateLeft r@Robot{ bearing = b } = 
    r{ bearing = case b of 
            North -> West
            West  -> South
            South -> East
            East  -> North }

rotateRight :: Robot -> Robot
rotateRight r@Robot{ bearing = b} = 
    r{ bearing = case b of 
            North -> East
            East  -> South
            South -> West
            West  -> North }

advance :: Robot -> Robot
advance r@Robot{ bearing = b, coordinates = (x, y) } =
    r{ coordinates = case b of
            North -> (x,     y + 1)
            East  -> (x + 1, y)
            South -> (x,     y - 1)
            West  -> (x - 1, y) }

move :: Robot -> String -> Robot
move robot [] = robot
move robot (instruction:is) =
    case instruction of
        'L' -> move (rotateLeft robot) is
        'R' -> move (rotateRight robot) is
        'A' -> move (advance robot) is
        _   -> error "Bad instruction"  -- Probably better to return Maybe Robot

