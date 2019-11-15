using System.Collections.Generic;
using System.Collections.ObjectModel;

public class SpaceAge
{
    private enum Planet
    {
        MERCURY,
        VENUS,
        EARTH,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUNE
    };

    private static readonly int EARTH_YEAR_IN_SECONDS = 31_557_600;

    private static readonly ReadOnlyDictionary<Planet, double> yearInSeconds = new ReadOnlyDictionary<Planet, double>
    (
        new Dictionary<Planet, double>()
        {
            { Planet.MERCURY, 0.2408467  * EARTH_YEAR_IN_SECONDS },
            { Planet.VENUS,   0.61519726 * EARTH_YEAR_IN_SECONDS },
            { Planet.EARTH,   1.0        * EARTH_YEAR_IN_SECONDS },
            { Planet.MARS,    1.8808158  * EARTH_YEAR_IN_SECONDS },
            { Planet.JUPITER, 11.862615  * EARTH_YEAR_IN_SECONDS },
            { Planet.SATURN,  29.447498  * EARTH_YEAR_IN_SECONDS },
            { Planet.URANUS,  84.016846  * EARTH_YEAR_IN_SECONDS },
            { Planet.NEPTUNE, 164.79132  * EARTH_YEAR_IN_SECONDS }
        }
    );

    private readonly int Seconds;

    public SpaceAge(int seconds) => Seconds = seconds;

    public double OnEarth() => Seconds / yearInSeconds[Planet.EARTH];
    public double OnMercury() => Seconds / yearInSeconds[Planet.MERCURY];
    public double OnVenus() => Seconds / yearInSeconds[Planet.VENUS];
    public double OnMars() => Seconds / yearInSeconds[Planet.MARS];
    public double OnJupiter() => Seconds / yearInSeconds[Planet.JUPITER];
    public double OnSaturn() => Seconds / yearInSeconds[Planet.SATURN];
    public double OnUranus() => Seconds / yearInSeconds[Planet.URANUS];
    public double OnNeptune() => Seconds / yearInSeconds[Planet.NEPTUNE];
}