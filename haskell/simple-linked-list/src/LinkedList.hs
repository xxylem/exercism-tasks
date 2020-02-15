module LinkedList
    ( LinkedList
    , datum
    , fromList
    , isNil
    , new
    , next
    , nil
    , reverseLinkedList
    , toList
    ) where

data LinkedList a = 
      Empty
    | Cons a (LinkedList a) deriving (Eq, Show)

datum :: LinkedList a -> a
datum Empty = error "Datum called on empty list"
datum (Cons x _) = x

fromList :: [a] -> LinkedList a
fromList = foldr Cons Empty

isNil :: LinkedList a -> Bool
isNil Empty = True
isNil _     = False

new :: a -> LinkedList a -> LinkedList a
new = Cons

next :: LinkedList a -> LinkedList a
next Empty = error "Next called on empty list"
next (Cons _ xs) = xs

nil :: LinkedList a
nil = Empty

reverseLinkedList :: LinkedList a -> LinkedList a
reverseLinkedList Empty = Empty
reverseLinkedList (Cons x xs) =
    reverseLinkedList xs `append` x

append :: LinkedList a -> a -> LinkedList a
append Empty x  = Cons x Empty
append (Cons y ys) x = Cons y (ys `append` x)

toList :: LinkedList a -> [a]
toList Empty = []
toList (Cons x xs) = x : toList xs
