#include "grains.h"

uint64_t square(uint8_t index)
{
	if (index < 1 || index > 64)
	{
		return 0;
	}

	// Each of the 64 squares on the board are represented by a bit position in a 64 bit ull.
	return 1ULL << (index - 1);
}

uint64_t total(void)
{
	// All squares is the same as all bits set in a 64 bit ull.
	return 18446744073709551615ULL;
}
