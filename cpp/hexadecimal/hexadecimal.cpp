#include "hexadecimal.h"

namespace hexadecimal {

	const int convert(const std::string& hexadecimal_number)
	{
		int decimal_number = 0;

		for (const char& hexadecimal_digit : hexadecimal_number)
		{
			int decimal_digit = convert(hexadecimal_digit);

			// Check invalid input.
			if (decimal_digit < 0)
				return 0;

			decimal_number += decimal_digit;
			decimal_number <<= 4;
		}

		decimal_number >>= 4;

		return decimal_number;
	}

	const int convert(const char& hexadecimal_digit)
	{
		int decimal_digits;

		if (islower(hexadecimal_digit))
			decimal_digits = 10 + hexadecimal_digit - 'a';

		else
			decimal_digits = hexadecimal_digit - '0';

		// Check invalid digit.
		if (decimal_digits < 0 || decimal_digits > 15)
			decimal_digits = -1;

		return decimal_digits;
	}
}  // namespace hexadecimal
