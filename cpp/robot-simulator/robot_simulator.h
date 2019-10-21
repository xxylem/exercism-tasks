#if !defined(ROBOT_SIMULATOR_H)
#define ROBOT_SIMULATOR_H

#include <string>
#include <utility>

namespace robot_simulator {

	const enum class Bearing 
	{
		NORTH,
		EAST,
		SOUTH,
		WEST
	};

	class Robot
	{
	public:
		// Constructors
		Robot();
		Robot(const std::pair<int, int>& position, const Bearing& bearing);

		// Getters
		const std::pair<int, int> get_position() const;
		const Bearing get_bearing() const;

		// Movement
		void turn_right();
		void turn_left();
		void advance();

		void execute_sequence(const std::string& sequence);

	private:
		std::pair<int, int> _position;
		Bearing _bearing;
	};

}  // namespace robot_simulator

#endif // ROBOT_SIMULATOR_H