#if !defined(ROBOT_NAME_H)
#define ROBOT_NAME_H
#include <string>
#include <cstdlib>
#include <ctime>
#include <unordered_set>
#include <sstream>

namespace robot_name {

	class robot
	{
	public:
		robot();
		std::string name() const;
		void reset();
	private:
		static const int MAX_TRIES = 20;
		void generate_name();
		std::string _name;
	};

}  // namespace robot_name

#endif // ROBOT_NAME_H