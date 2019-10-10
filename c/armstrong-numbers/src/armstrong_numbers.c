#include "armstrong_numbers.h"
#include <math.h>
#include <stdlib.h>
#include <stdio.h>

int count_number_of_digits(int x) {

	if (x == 0) {
		return 1;
	}

	x = abs(x);
	int num_digits = 0;

	while (x > 0) {
		x /= 10;
		num_digits++;
	}

	return num_digits;
}

int is_armstrong_number(int x)
{
	int num_digits = count_number_of_digits(x);
	int sum = 0;
	int x_original = x;

	for (int i = 0; i < num_digits; i++) {
		sum += (int) (pow(x % 10, num_digits) + 0.5);
		x /= 10;
	}

	return sum == x_original;
}
