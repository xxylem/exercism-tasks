#include "space_age.h"

namespace space_age {

	static const double earth_year_in_seconds = 31557600;
	static const std::map<Planet, double> year_in_seconds = {
		{ Planet::MERCURY, 0.2408467  * earth_year_in_seconds },
		{ Planet::VENUS,   0.61519726 * earth_year_in_seconds },
		{ Planet::EARTH,   1.0        * earth_year_in_seconds },
		{ Planet::MARS,    1.8808158  * earth_year_in_seconds },
		{ Planet::JUPITER, 11.862615  * earth_year_in_seconds },
		{ Planet::SATURN,  29.447498  * earth_year_in_seconds },
		{ Planet::URANUS,  84.016846  * earth_year_in_seconds },
		{ Planet::NEPTUNE, 164.79132  * earth_year_in_seconds }
	};

	space_age::space_age(long long int seconds) : _seconds(seconds) {}
	
	long long int space_age::seconds() const { return _seconds; }

	double space_age::on_mercury() const { return _seconds / year_in_seconds.at(Planet::MERCURY); }
	double space_age::on_venus()   const { return _seconds / year_in_seconds.at(Planet::VENUS); }
	double space_age::on_earth()   const { return _seconds / year_in_seconds.at(Planet::EARTH); }
	double space_age::on_mars()    const { return _seconds / year_in_seconds.at(Planet::MARS); }
	double space_age::on_jupiter() const { return _seconds / year_in_seconds.at(Planet::JUPITER); }
	double space_age::on_saturn()  const { return _seconds / year_in_seconds.at(Planet::SATURN); }
	double space_age::on_uranus()  const { return _seconds / year_in_seconds.at(Planet::URANUS); }
	double space_age::on_neptune() const { return _seconds / year_in_seconds.at(Planet::NEPTUNE); }

}  // namespace space_age
