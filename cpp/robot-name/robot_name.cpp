#include "robot_name.h"

namespace robot_name {

	static std::unordered_set<std::string> names_in_use;

	robot::robot() { this->generate_name();	}

	std::string robot::name() const { return _name; }

	void robot::reset()
	{
		this->generate_name();
	}

	void robot::generate_name()
	{
		std::string old_name = this->_name;
		std::string generated_name;
		do {
			std::stringstream ss;
			ss << (char)('A' + rand() % 26)
				<< (char)('A' + rand() % 26)
				<< rand() % 10
				<< rand() % 10
				<< rand() % 10;
			generated_name = ss.str();

		} while (names_in_use.count(generated_name));

		this->_name = generated_name;

		if (!old_name.empty())
			names_in_use.erase(old_name);
	}

}  // namespace robot_name
