#include "difference_of_squares.h"

namespace difference_of_squares {

	long int square_of_sum(int n)
	{
		long int sum = (n * (n + 1)) / 2;
		return sum * sum;

	}

	long int sum_of_squares(int n)
	{
		long int sum = ((2 * n + 1) * n * (n + 1)) / 6;
		return sum;
	}

	long int difference(int n)
	{
		return square_of_sum(n) - sum_of_squares(n);
	}

}  // namespace difference_of_squares
