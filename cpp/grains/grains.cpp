#include "grains.h"

namespace grains {
	const unsigned long long square(int n)
	{
		// Each square is represented by one bit in the 64-bit ULL.
		return 1ULL << (n - 1);
	}
	const unsigned long long total()
	{
		return 18446744073709551615ULL;
	}
}  // namespace grains
