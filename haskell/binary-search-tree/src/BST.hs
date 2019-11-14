module BST
    ( BST
    , bstLeft
    , bstRight
    , bstValue
    , empty
    , fromList
    , insert
    , singleton
    , toList
    ) where

data BST a =
      Node { val :: a
           , left :: BST a
           , right :: BST a }
    | Empty
    deriving (Eq, Show)

bstLeft :: BST a -> Maybe (BST a)
bstLeft (Node _ l _) = Just l
bstLeft Empty = Nothing

bstRight :: BST a -> Maybe (BST a)
bstRight (Node _ _ r) = Just r
bstRight Empty = Nothing

bstValue :: BST a -> Maybe a
bstValue (Node v _ _) = Just v
bstValue Empty = Nothing

empty :: BST a
empty = Empty

fromList :: Ord a => [a] -> BST a
fromList = foldl (flip insert) Empty

insert :: Ord a => a -> BST a -> BST a
insert x (Node v l r) = case compare x v of
    GT -> Node v l (insert x r)
    _  -> Node v (insert x l) r
insert x Empty = Node x Empty Empty

singleton :: a -> BST a
singleton x = Node x Empty Empty

toList :: BST a -> [a]
toList (Node v l r) = toList l ++ [v] ++ toList r
toList Empty = []
