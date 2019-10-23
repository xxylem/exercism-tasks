from enum import Enum, auto


class Planet(Enum):
    MERCURY = auto()
    VENUS = auto()
    EARTH = auto()
    MARS = auto()
    JUPITER = auto()
    SATURN = auto()
    URANUS = auto()
    NEPTUNE = auto()


EARTH_YEAR_IN_SECONDS = 31557600.0
YEAR_IN_SECONDS = {
    Planet.MERCURY: 0.2408467 * EARTH_YEAR_IN_SECONDS,
    Planet.VENUS: 0.61519726 * EARTH_YEAR_IN_SECONDS,
    Planet.EARTH: EARTH_YEAR_IN_SECONDS,
    Planet.MARS: 1.8808158 * EARTH_YEAR_IN_SECONDS,
    Planet.JUPITER: 11.862615 * EARTH_YEAR_IN_SECONDS,
    Planet.SATURN: 29.447498 * EARTH_YEAR_IN_SECONDS,
    Planet.URANUS: 84.016846 * EARTH_YEAR_IN_SECONDS,
    Planet.NEPTUNE: 164.79132 * EARTH_YEAR_IN_SECONDS,
}


class SpaceAge(object):

    def __init__(self, seconds):
        self.seconds = seconds
        self.age_in_seconds_on_planet = {}

    def compute_planet_year_if_absent(self, planet):
        if planet in self.age_in_seconds_on_planet:
            return self.age_in_seconds_on_planet[planet]
        else:
            age = round(self.seconds / YEAR_IN_SECONDS[planet], 2)
            self.age_in_seconds_on_planet[planet] = age
            return age

    def on_earth(self):
        return self.compute_planet_year_if_absent(Planet.EARTH)

    def on_mercury(self):
        return self.compute_planet_year_if_absent(Planet.MERCURY)

    def on_venus(self):
        return self.compute_planet_year_if_absent(Planet.VENUS)

    def on_mars(self):
        return self.compute_planet_year_if_absent(Planet.MARS)

    def on_jupiter(self):
        return self.compute_planet_year_if_absent(Planet.JUPITER)

    def on_saturn(self):
        return self.compute_planet_year_if_absent(Planet.SATURN)

    def on_uranus(self):
        return self.compute_planet_year_if_absent(Planet.URANUS)

    def on_neptune(self):
        return self.compute_planet_year_if_absent(Planet.NEPTUNE)




