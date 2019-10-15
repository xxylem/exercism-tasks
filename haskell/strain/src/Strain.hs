module Strain (keep, discard) where

-- Filters list by predicate p.
-- NB: Explicit recursive definition since library functions
--      are disallowed by restrictions in problem statement.    
keep :: (a -> Bool) -> [a] -> [a]
keep _ [] = []
keep p (x:xs) =
    if p x
        then x : keep p xs
        else keep p xs
        
-- Filters list by ~p.      
discard :: (a -> Bool) -> [a] -> [a]
discard p = keep (not . p)