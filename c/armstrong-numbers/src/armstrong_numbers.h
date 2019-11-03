#ifndef ARMSTRONG_NUMBERS
#define ARMSTRONG_NUMBERS

#include <stdbool.h>

/** Input: a nonnegative integer, x.
	Output: true if x is an Armstrong number:
				x equals the sum of 
				(each digit of x raised to the total number of digits in x)
			false otherwise */
bool is_armstrong_number(int x);

#endif
