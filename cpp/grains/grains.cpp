#include <limits>
#include "grains.h"

namespace grains {
	const unsigned long long square(int n)
	{
		// Each square is represented by one bit in the 64-bit ULL.
		return 1ULL << (n - 1);
	}
	const unsigned long long total()
	{
		// Each square is one bit in a ULL, so the total is all bits flipped to one, i.e. the max value.
		return ULLONG_MAX;
	}
}  // namespace grains
