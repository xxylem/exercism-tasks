#if !defined(SPACE_AGE_H)
#define SPACE_AGE_H

#include <map>
#include <string>


namespace space_age {

	class space_age
	{
	public:
		space_age(long long int seconds);
		long long int seconds() const;

		double on_mercury() const;
		double on_venus() const;
		double on_earth() const;
		double on_mars() const;
		double on_jupiter() const;
		double on_saturn() const;
		double on_uranus() const;
		double on_neptune() const;

	private:
		const long long int _seconds;
	};

}  // namespace space_age

#endif // SPACE_AGE_H