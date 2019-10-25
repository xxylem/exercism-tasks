#include "leap.h"

namespace leap {

	const bool is_leap_year(int year)
	{
		return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
	}

}  // namespace leap
