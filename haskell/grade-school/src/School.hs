module School (School, add, empty, grade, sorted) where

import Data.List (sort)
import qualified Data.IntMap.Strict as M

type Grade = Int
type Name = String

-- INVARIANT: The names of each grade are stored in alphabetical
--              order from A to Z.
type School = M.IntMap [Name]


add :: Grade -> Name -> School -> School
add gradeNum name = M.insertWith (\old new ->
                        sort $ old ++ new) gradeNum [name]

empty :: School
empty = M.empty

grade :: Grade -> School -> [Name]
grade = M.findWithDefault []

sorted :: School -> [(Grade, [Name])]
sorted = M.toAscList
