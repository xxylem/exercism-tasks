#if !defined(HEXADECIMAL_H)
#define HEXADECIMAL_H

#include <string>

namespace hexadecimal {

	/** Convert the hexadecimal_number to decimal.
		Returns 0 on invalid input. */
	const int convert(const std::string& hexadecimal_number);
	/** Convert the hexadecimal_digit to decimal.
		Returns -1 on invalid input. */
	const int convert(const char& hexadecimal_digit);
	
}  // namespace hexadecimal

#endif // HEXADECIMAL_H