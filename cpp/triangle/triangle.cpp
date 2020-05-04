#include "triangle.h"
#include <stdexcept>

namespace triangle {

	const flavor kind(double a, double b, double c)
	{
		if (!isLegalTriangle(a, b, c))
		{
			throw std::domain_error("Not a valid triangle.");
		}

		// For the test data, == on floating point is sufficient.
		// Without knowing more about the input data, there's not much
		// more we can do.
		if (a == b && b == c)
		{
			return flavor::equilateral;
		}

		if (a == b || a == c || b == c)
		{
			return flavor::isosceles;
		}

		return flavor::scalene;
	}

	const bool isLegalTriangle(double a, double b, double c)
	{
		return a > 0 && b > 0 && c > 0
			&& (a + b >= c)
			&& (a + c >= b)
			&& (b + c >= a);
	}

}  // namespace triangle
