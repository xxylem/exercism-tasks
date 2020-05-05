#include <stddef.h>
#include "hamming.h"

// Assumes strings only contain valid nucleotide characters C, A, G and T
int compute(const char* lhs, const char* rhs)
{
	if (lhs == NULL || rhs == NULL)
	{
		return -1;
	}

	int distance = 0;

	const char* cLeft = lhs;
	const char* cRight = rhs;
	while (*cLeft != '\0' && *cRight != '\0')
	{
		if (*cLeft != *cRight)
		{
			distance++;
		}

		cLeft++;
		cRight++;
	}

	if (*cLeft != '\0' || *cRight != '\0')
	{
		// Handles length mismatch.
		return -1;
	}

	return distance;
}
