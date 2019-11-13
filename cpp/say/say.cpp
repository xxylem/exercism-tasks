#include "say.h"
#include <stdexcept>
#include <vector>

namespace say {

	std::string ones(int onesDigit)
	{
		switch (onesDigit)
		{
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return std::string();
		}
	}

	std::string teens(int tensAndOnes)
	{
		switch (tensAndOnes)
		{
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "ninteen";
		default:
			return std::string();
		}
	}

	std::string tens(int tens)
	{
		switch (tens)
		{
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "forty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		default:
			return std::string();
		}
	}

	std::string zero_to_ninety_nine(unsigned long long n)
	{
		int tensAndOnes = n % 100;

		if (tensAndOnes > 9 && tensAndOnes < 20)
			return teens(tensAndOnes);

		int onesDigit = tensAndOnes % 10;
		std::string ones_s = ones(onesDigit);
		std::string tens_s = tens(tensAndOnes - onesDigit);
		
		if (!ones_s.empty() && !tens_s.empty())
			return tens_s + "-" + ones_s;
		if (!tens_s.empty())
			return tens_s;
		return ones_s;
	}

	std::string zero_to_nine_hundred_ninety_nine(unsigned long long n) {

		std::string hundreds_digit_s = ones((n % 1000) / 100);
		std::string tensAndOnes = zero_to_ninety_nine(n);

		if (!hundreds_digit_s.empty() && !tensAndOnes.empty())
			return hundreds_digit_s + " hundred " + tensAndOnes;

		if (!hundreds_digit_s.empty())
			return hundreds_digit_s + " hundred";

		return tensAndOnes;
	}

	std::string in_english(unsigned long long n)
	{
		if (n < 0)
			throw std::domain_error("Number must be non-negative.");

		if (n > 999999999999ULL)
			throw std::domain_error("Number too large");

		// Zero handled separately since it is not used for thousands, millions etc. I.e. we do not say "zero thousand".
		if (n == 0)
			return "zero";

		const static std::vector<std::string> units_suffix = {
			"", " thousand", " million", " billion"  // 0-999 have no explicit unit.
		};
		
		std::string number;
		for (int i = 0; i < 4 && n > 0; i++) {
			int three_digits = n % 1000;
			n /= 1000;
			std::string three_digits_s = zero_to_nine_hundred_ninety_nine(three_digits);

			if (!three_digits_s.empty())
				number = three_digits_s + units_suffix[i] + (!number.empty() ? " " + number : "");
		}

		return number;
	}
}  // namespace say
