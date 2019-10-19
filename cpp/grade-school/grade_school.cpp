#include "grade_school.h"
#include <algorithm>
#include <stdexcept>

namespace grade_school {

	using namespace std;

	/** Returns: List of all grades in the school, each grade being a list of students
				 in that grade. */
	map <int, vector<string>> school::roster() const 
	{
		return _roster;
	}

	void school::add(std::string name, int grade)
	{
		// INVARIANT: Students are added to the grade roster s.t. they are
		//			  stored alphabetically.
		vector<string> &grade_roster = _roster[grade];
		grade_roster.insert
		(
			std::upper_bound(grade_roster.begin(), grade_roster.end(), name),
			name
		);
	}

	/** Returns: sorted list of students in the given grade. */
	vector<string> school::grade(int g) const
	{
		try
		{
			return _roster.at(g);
		}
		catch (const out_of_range&)
		{
			return {};
		}
		
	}

}  // namespace grade_school
