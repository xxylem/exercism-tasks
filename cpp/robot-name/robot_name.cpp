#include "robot_name.h"
#include <sstream>

namespace robot_name {

	robot::robot() { this->generate_name();	}

	std::string robot::name() const { return _name; }

	void robot::reset()
	{
		std::string old_name = this->_name;
		for (int i = 0; i < MAX_TRIES; i++) {
			this->generate_name();
			if (old_name.compare(this->_name))
				return;
		}
		throw std::runtime_error("Failed to generate new name. Perhaps the name pool is exhausted.");
	}

	void robot::generate_name()
	{
		std::stringstream ss;
		ss << (char) ('A' + rand() % 26) 
			<< (char) ('A' + rand() % 26) 
			<< rand() % 10 
			<< rand() % 10 
			<< rand() % 10;

		this->_name = ss.str();
	}

}  // namespace robot_name
