#include "luhn.h"
#include <vector>
#include <iostream>

namespace luhn {

	using namespace std;

	const bool valid(const string& number)
	{
		const size_t len = number.size();
		if (len <= 1)
			return false;
			
		int sum = 0;
		int num_digits_seen = 0;
		bool double_this_digit = false;

		for (int i = (int) len - 1; i >= 0; i--)
		{
			const char& c = number.at(i);

			if (isdigit(c))
			{
				int digit = c - '0';

				if (double_this_digit)
				{
					digit *= 2;
					if (digit > 9)
						digit -= 9;
				}	
				
				sum += digit;
				double_this_digit = !double_this_digit;
				num_digits_seen++;
			}
			else if (c == ' ')
				continue;
			else
				return false;
		}
		
		return num_digits_seen > 1 && (sum % 10) == 0;
	}

}  // namespace luhn
