#if !defined(GRADE_SCHOOL_H)
#define GRADE_SCHOOL_H

#include <map>
#include <string>
#include <vector>

namespace grade_school {

	class school
	{
	public:

		// Names of students are stored together in their grade.
		std::map <int, std::vector<std::string>> roster() const;
		void add(std::string name, int grade);
		std::vector<std::string> grade(int g) const;

	private:

		std::map <int, std::vector<std::string>> _roster;

	};

	

}  // namespace grade_school

#endif // GRADE_SCHOOL_H