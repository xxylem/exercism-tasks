#if !defined(ALL_YOUR_BASE_H)
#define ALL_YOUR_BASE_H

#include <vector>

namespace all_your_base {

	// Convert number in arbitrary base to number in a different arbitrary base.
	const std::vector<unsigned int> convert(const int& in_base,
		const std::vector<unsigned int>& in_digits, const int& out_base);

	// Convert number in arbitrary base to decimal.
	const int convert(const int& in_base,
		const std::vector<unsigned int>& in_digits);

	// Convert number in decimal to arbitrary base.
	const std::vector<unsigned int> convert(int decimal_number, const int& out_base);

}  // namespace all_your_base

#endif // ALL_YOUR_BASE_H