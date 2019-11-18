#include "space_age.h"

namespace space_age {

	// Indices are meaningful. Do not change.
	enum Planet {
		MERCURY = 0, VENUS = 1, EARTH = 2, MARS = 3, JUPITER = 4, SATURN = 5, URANUS = 6, NEPTUNE = 7
	};

	static const double earth_year_in_seconds = 31557600;

	// Array is accessed using the Planet enum. The entry at index i refers to the planet in the enum with ordinal i.
	static const double year_in_seconds[] = {
		0.2408467  * earth_year_in_seconds, // Mercury
		0.61519726 * earth_year_in_seconds, // Venus
		1.0        * earth_year_in_seconds, // Earth
		1.8808158  * earth_year_in_seconds, // Mars
		11.862615  * earth_year_in_seconds, // Jupiter
		29.447498  * earth_year_in_seconds, // Saturn
		84.016846  * earth_year_in_seconds, // Uranus
		164.79132  * earth_year_in_seconds  // Neptune
	};

	space_age::space_age(long long int seconds) : _seconds(seconds) {}
	
	long long int space_age::seconds() const { return _seconds; }

	double space_age::on_mercury() const { return _seconds / year_in_seconds[Planet::MERCURY]; }
	double space_age::on_venus()   const { return _seconds / year_in_seconds[Planet::VENUS]; }
	double space_age::on_earth()   const { return _seconds / year_in_seconds[Planet::EARTH]; }
	double space_age::on_mars()    const { return _seconds / year_in_seconds[Planet::MARS]; }
	double space_age::on_jupiter() const { return _seconds / year_in_seconds[Planet::JUPITER]; }
	double space_age::on_saturn()  const { return _seconds / year_in_seconds[Planet::SATURN]; }
	double space_age::on_uranus()  const { return _seconds / year_in_seconds[Planet::URANUS]; }
	double space_age::on_neptune() const { return _seconds / year_in_seconds[Planet::NEPTUNE]; }

}  // namespace space_age
