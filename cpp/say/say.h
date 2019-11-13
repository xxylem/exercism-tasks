#if !defined(SAY_H)
#define SAY_H

#include <string>

namespace say {
	std::string ones(int n);
	std::string teens(int n);
	std::string tens(int n);
	std::string zero_to_ninety_nine(unsigned long long n);
	std::string zero_to_nine_hundred_ninety_nine(unsigned long long n);
	std::string in_english(unsigned long long n);

}  // namespace say

#endif // SAY_H