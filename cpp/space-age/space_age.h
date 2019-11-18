#if !defined(SPACE_AGE_H)
#define SPACE_AGE_H
namespace space_age {

	static const double EARTH_YEAR_IN_SECONDS = 31557600;
	static const double MERCURY_YEAR_IN_SECONDS = 0.2408467 * EARTH_YEAR_IN_SECONDS;
	static const double VENUS_YEAR_IN_SECONDS = 0.61519726 * EARTH_YEAR_IN_SECONDS;
	static const double MARS_YEAR_IN_SECONDS = 1.8808158 * EARTH_YEAR_IN_SECONDS;
	static const double JUPITER_YEAR_IN_SECONDS = 11.862615 * EARTH_YEAR_IN_SECONDS;
	static const double SATURN_YEAR_IN_SECONDS = 29.447498 * EARTH_YEAR_IN_SECONDS;
	static const double URANUS_YEAR_IN_SECONDS = 84.016846 * EARTH_YEAR_IN_SECONDS;
	static const double NEPTUNE_YEAR_IN_SECONDS = 164.79132 * EARTH_YEAR_IN_SECONDS;

	class space_age
	{
	public:
		constexpr space_age::space_age(long long int seconds) noexcept : _seconds(seconds) {}
		constexpr long long int space_age::seconds() const noexcept { return _seconds; }

		constexpr double space_age::on_mercury() const noexcept { return _seconds / MERCURY_YEAR_IN_SECONDS; }
		constexpr double space_age::on_venus()   const noexcept { return _seconds / VENUS_YEAR_IN_SECONDS; }
		constexpr double space_age::on_earth()   const noexcept { return _seconds / EARTH_YEAR_IN_SECONDS; }
		constexpr double space_age::on_mars()    const noexcept { return _seconds / MARS_YEAR_IN_SECONDS; }
		constexpr double space_age::on_jupiter() const noexcept { return _seconds / JUPITER_YEAR_IN_SECONDS; }
		constexpr double space_age::on_saturn()  const noexcept { return _seconds / SATURN_YEAR_IN_SECONDS; }
		constexpr double space_age::on_uranus()  const noexcept { return _seconds / URANUS_YEAR_IN_SECONDS; }
		constexpr double space_age::on_neptune() const noexcept { return _seconds / NEPTUNE_YEAR_IN_SECONDS; }

	private:
		const long long int _seconds;
	};

}  // namespace space_age

#endif // SPACE_AGE_H