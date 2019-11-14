module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune

yearInSeconds :: Planet -> Float
yearInSeconds planet = case planet of
    Mercury -> 0.2408467  * earthYearInSeconds
    Venus   -> 0.61519726 * earthYearInSeconds
    Earth   ->              earthYearInSeconds
    Mars    -> 1.8808158  * earthYearInSeconds
    Jupiter -> 11.862615  * earthYearInSeconds
    Saturn  -> 29.447498  * earthYearInSeconds
    Uranus  -> 84.016846  * earthYearInSeconds
    Neptune -> 164.79132  * earthYearInSeconds
    where earthYearInSeconds = 31557600

ageOn :: Planet -> Float -> Float
ageOn planet seconds =
    seconds / yearInSeconds planet
