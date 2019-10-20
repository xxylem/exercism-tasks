#include "armstrong_numbers.h"
#include <vector>

namespace armstrong_numbers {

	using namespace std;

	const bool is_armstrong_number(const int& number)
	{
		// While 0 is correctly handled implicitly below, it is only by accident, so
		// we explicitly define the case here.
		if (number == 0)
			return true;

		// Store the digits found since we cannot know the power to raise each digit to
		// until the total number of digits is known.
		vector<int> digits;
		int num_digits = 0;

		// Get a list of all the digits in number;
		int number_copy = number;
		while (number_copy > 0) {
			digits.push_back(number_copy % 10);
			number_copy /= 10;
			num_digits++;
		}

		int sum = 0;
		for (const int& digit : digits)
			sum += (int) (pow(digit, num_digits) + 0.5);

		return number == sum;
	}

}  // namespace armstrong_numbers
