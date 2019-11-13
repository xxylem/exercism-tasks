#include "say.h"
#include <stdexcept>

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
			return "fourty";
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

	std::string in_english(unsigned long long n)
	{
		if (n < 0)
			throw std::domain_error("Number must be non-negative.");

		if (n > 999999999999ULL)
			throw std::domain_error("Number too large");

		if (n == 0)
			return "zero";
		
		return zero_to_ninety_nine(n);
	}
}  // namespace say
