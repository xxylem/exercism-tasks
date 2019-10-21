#include "robot_simulator.h"

namespace robot_simulator {

	using namespace std;
	
	Robot::Robot() : _position({ 0, 0 }), _bearing(Bearing::NORTH) {}

	Robot::Robot(const pair<int, int>& position, const Bearing& bearing) : 
		_position(position), _bearing(bearing) {}

	const pair<int, int> Robot::get_position() const { return _position; }
	const Bearing Robot::get_bearing() const { return _bearing; }

	void Robot::turn_right()
	{
		switch (_bearing)
		{
		case Bearing::NORTH:
			_bearing = Bearing::EAST;
			return;

		case Bearing::EAST:
			_bearing = Bearing::SOUTH;
			return;

		case Bearing::SOUTH:
			_bearing = Bearing::WEST;
			return;

		case Bearing::WEST:
			_bearing = Bearing::NORTH;
			return;
		}
	}

	void Robot::turn_left()
	{
		switch (_bearing)
		{
		case Bearing::NORTH:
			_bearing = Bearing::WEST;
			return;

		case Bearing::EAST:
			_bearing = Bearing::NORTH;
			return;

		case Bearing::SOUTH:
			_bearing = Bearing::EAST;
			return;

		case Bearing::WEST:
			_bearing = Bearing::SOUTH;
			return;
		}
	}

	void Robot::advance()
	{
		switch (_bearing)
		{
		case Bearing::NORTH:
			_position.second++;
			return;

		case Bearing::EAST:
			_position.first++;
			return;

		case Bearing::SOUTH:
			_position.second--;
			return;

		case Bearing::WEST:
			_position.first--;
			return;
		}
	}

	void Robot::execute_sequence(const string& sequence)
	{
		for (const char& instruction : sequence) {
			switch (instruction)
			{
			case 'R':
				this->turn_right();
				break;
			case 'L':
				this->turn_left();
				break;
			case 'A':
				this->advance();
			}
		}
	}

}  // namespace robot_simulator
