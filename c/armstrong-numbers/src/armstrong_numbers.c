#include "armstrong_numbers.h"
#include <math.h>

bool is_armstrong_number(int x)
{	
	int num_digits = x != 0 ? floor(log10(x)) + 1 : 1;

	int sum = 0;
	for (int x_copy = x; x_copy > 0; x_copy /= 10)
		sum += (int) pow(x_copy % 10, num_digits);

	return sum == x;
}
