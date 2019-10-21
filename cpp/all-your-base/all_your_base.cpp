#include "all_your_base.h"
#include <stdexcept>

namespace all_your_base {

	using namespace std;

	const vector<unsigned int> convert(const int& in_base, 
		const vector<unsigned int>& in_digits, const int& out_base)
	{
		if (in_base <= 1 || out_base <= 1)
			throw invalid_argument("Bases must be 2 or greater.");

		return convert(convert(in_base, in_digits), out_base);
	}

	const int convert(const int& in_base, const vector<unsigned int>& in_digits)
	{
		int multiplicand = 1;
		int decimal_number = 0;
		for (int i = ((int) in_digits.size()) - 1; i >= 0; i--) 
		{
			const int& digit = in_digits.at(i);

			if (digit >= in_base)
				throw invalid_argument("The input digits must be less than the base.");

			decimal_number += digit * multiplicand;
			multiplicand *= in_base;
		}

		return decimal_number;
	}

	const vector<unsigned int> convert(int decimal_number, const int& out_base)
	{
		vector<unsigned int> out_digits;
		while (decimal_number > 0)
		{
			// Potentially slow appended to the front of the vector.
			// If after profiling it turns out to be a major bottleneck, we could
			// use a deque instead.
			out_digits.insert(out_digits.begin(), decimal_number % out_base);
			decimal_number /= out_base;
		}

		return out_digits;
	}
}  // namespace all_your_base
