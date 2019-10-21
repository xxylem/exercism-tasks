import java.util.HashMap;

class SpaceAge {

    private enum Planet { MERCURY, VENUS, EARTH, MARS,
                            JUPITER, SATURN, URANUS,  NEPTUNE }

    private final double seconds;

    // Only contains a value for a given planet once the respective onPlanet method
    // has been called.
    private HashMap<Planet, Double> planet_years = new HashMap<>();

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() { return seconds; }

    // Only compute values when they are asked for, storing the result for future requests.
    double onEarth()   { return planet_years.computeIfAbsent(Planet.EARTH,   this::computePlanetYear); }
    double onMercury() { return planet_years.computeIfAbsent(Planet.MERCURY, this::computePlanetYear); }
    double onVenus()   { return planet_years.computeIfAbsent(Planet.VENUS,   this::computePlanetYear); }
    double onMars()    { return planet_years.computeIfAbsent(Planet.MARS,    this::computePlanetYear); }
    double onJupiter() { return planet_years.computeIfAbsent(Planet.JUPITER, this::computePlanetYear); }
    double onSaturn()  { return planet_years.computeIfAbsent(Planet.SATURN,  this::computePlanetYear); }
    double onUranus()  { return planet_years.computeIfAbsent(Planet.URANUS,  this::computePlanetYear); }
    double onNeptune() { return planet_years.computeIfAbsent(Planet.NEPTUNE, this::computePlanetYear); }

    // Only compute these once. To be used in computePlanetYear.
    private static final double EARTH_YEAR_SECONDS = 31557600;
    private static final double MERCURY_YEAR_SECONDS = 0.2408467 * EARTH_YEAR_SECONDS;
    private static final double VENUS_YEAR_SECONDS = 0.61519726 * EARTH_YEAR_SECONDS;
    private static final double MARS_YEAR_SECONDS = 1.8808158 * EARTH_YEAR_SECONDS;
    private static final double JUPITER_YEAR_SECONDS = 11.862615 * EARTH_YEAR_SECONDS;
    private static final double SATURN_YEAR_SECONDS = 29.447498 * EARTH_YEAR_SECONDS;
    private static final double URANUS_YEAR_SECONDS = 84.016846 * EARTH_YEAR_SECONDS;
    private static final double NEPTUNE_YEAR_SECONDS = 164.79132 * EARTH_YEAR_SECONDS;

    private double computePlanetYear(Planet planet) {
        switch (planet) {
            case MERCURY:
                return seconds / MERCURY_YEAR_SECONDS;
            case VENUS:
                return seconds / VENUS_YEAR_SECONDS;
            case EARTH:
                return seconds / EARTH_YEAR_SECONDS;
            case MARS:
                return seconds / MARS_YEAR_SECONDS;
            case JUPITER:
                return seconds / JUPITER_YEAR_SECONDS;
            case SATURN:
                return seconds / SATURN_YEAR_SECONDS;
            case URANUS:
                return seconds / URANUS_YEAR_SECONDS;
            case NEPTUNE:
                return seconds / NEPTUNE_YEAR_SECONDS;
            default:
                throw new IllegalArgumentException();
        }
    }
}

