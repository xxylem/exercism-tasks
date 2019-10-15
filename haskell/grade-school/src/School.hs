module School (School, add, empty, grade, sorted) where

import Data.List (sort)
import qualified Data.IntMap.Strict as M

type Grade = Int
type Name = String
type School = M.IntMap [Name]


add :: Grade -> Name -> School -> School
add gradeNum name = M.insertWith (++) gradeNum [name]

empty :: School
empty = M.empty

grade :: Grade -> School -> [Name]
grade gradeNum school = sort $ M.findWithDefault [] gradeNum school

sorted :: School -> [(Grade, [Name])]
sorted school = map (\(g, names) ->
                        (g, sort names))  (M.toAscList school)
