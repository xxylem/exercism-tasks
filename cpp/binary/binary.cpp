#include "binary.h"

namespace binary {

	const int convert(const std::string& binary_string)
	{
		unsigned int decimal = 0;
		unsigned int multiplicand = 1;

		for (int i = binary_string.size() - 1; i >= 0; i--) 
		{
			switch (binary_string.at(i))
			{
			case '1':
				decimal += 1 * multiplicand;
			case '0':
				break;
			default:
				return 0;
			}
			multiplicand *= 2;
		}

		return decimal;
	}
}  // namespace binary
