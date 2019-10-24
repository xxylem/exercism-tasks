#include "leap.h"

namespace leap {

	const bool is_leap_year(int year)
	{
		if (year % 400 == 0)
			return true;
		
		if (year % 100 == 0)
			return false;

		return year % 4 == 0;
	}

}  // namespace leap
