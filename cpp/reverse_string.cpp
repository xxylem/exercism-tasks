#include "reverse_string.h"

namespace reverse_string {
	std::string reverse_string(std::string input)
	{
		reverse(input.begin(), input.end());
		return input;
	}
}  // namespace reverse_string
