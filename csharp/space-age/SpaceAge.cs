using System.Collections.Generic;
using System.Collections.ObjectModel;

public class SpaceAge
{
    private static readonly int EARTH_YEAR_IN_SECONDS = 31_557_600;

    private static readonly ReadOnlyDictionary<string, double> yearInSeconds = new ReadOnlyDictionary<string, double>
    (
        new Dictionary<string, double>()
        {
            { "mercury", 0.2408467  * EARTH_YEAR_IN_SECONDS },
            { "venus",   0.61519726 * EARTH_YEAR_IN_SECONDS },
            { "earth",   1.0        * EARTH_YEAR_IN_SECONDS },
            { "mars",    1.8808158  * EARTH_YEAR_IN_SECONDS },
            { "jupiter", 11.862615  * EARTH_YEAR_IN_SECONDS },
            { "saturn",  29.447498  * EARTH_YEAR_IN_SECONDS },
            { "uranus",  84.016846  * EARTH_YEAR_IN_SECONDS },
            { "neptune", 164.79132  * EARTH_YEAR_IN_SECONDS }
        }
    );

    private readonly int Seconds;

    public SpaceAge(int seconds) => Seconds = seconds;

    public double OnEarth() => Seconds / yearInSeconds["earth"];
    public double OnMercury() => Seconds / yearInSeconds["mercury"];
    public double OnVenus() => Seconds / yearInSeconds["venus"];
    public double OnMars() => Seconds / yearInSeconds["mars"];
    public double OnJupiter() => Seconds / yearInSeconds["jupiter"];
    public double OnSaturn() => Seconds / yearInSeconds["saturn"];
    public double OnUranus() => Seconds / yearInSeconds["uranus"];
    public double OnNeptune() => Seconds / yearInSeconds["neptune"];
}