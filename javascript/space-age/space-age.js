/** INPUT: planet (string): name of planet
 *         age_seconds (number): age of person in seconds
 *  OUTPUT: The age of the person in years if they were on given planet. */
export const age = (planet, age_seconds) => {
  return Math.round(100 * (age_seconds / planet_years_in_seconds(planet))) / 100;
};

const EARTH_YEAR_IN_SECONDS = 31557600;

const PLANET_YEARS_IN_EARTH_YEARS = {
    'mercury' : 0.2408467
  , 'venus'   : 0.61519726
  , 'earth'   : 1
  , 'mars'    : 1.8808158
  , 'jupiter' : 11.862615
  , 'saturn'  : 29.447498
  , 'uranus'  : 84.016846
  , 'neptune' : 164.79132
}

/** INPUT: planet (string): name of planet
 *  OUTPUT: The length of a year on given planet in seconds. */
const planet_years_in_seconds = (planet) =>
  PLANET_YEARS_IN_EARTH_YEARS[planet] * EARTH_YEAR_IN_SECONDS;