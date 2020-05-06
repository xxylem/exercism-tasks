#include "grains.h"

namespace grains {
	unsigned long long square(int n)
	{
		// Each square is represented by one bit in the 64-bit ULL.
		return 1ULL << (n - 1);
	}
	unsigned long long total()
	{
		return 0xFFFF'FFFF'FFFF'FFFFULL;
	}
}  // namespace grains
