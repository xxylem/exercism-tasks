module Triangle (TriangleType(..), triangleType) where

data TriangleType = Equilateral
                  | Isosceles
                  | Scalene
                  | Illegal
                  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c 
    | isTriangle a b c = determineType
    | otherwise        = Illegal
    where determineType
            | a == b && b == c           = Equilateral
            | a == b || a == c || b == c = Isosceles
            | otherwise                  = Scalene 

isTriangle :: (Num a, Ord a) => a -> a -> a -> Bool
isTriangle a b c = a > 0 && b > 0 && c > 0
    && a + b >= c
    && a + c >= b
    && b + c >= a

    