#ifndef ARMSTRONG_NUMBERS
#define ARMSTRONG_NUMBERS

#include <stdbool.h>

// Linked list
typedef struct node {
	int val;
	struct node* next;
} node;

// Contains a list of digits and the total number of digits.
typedef struct {
	int number_of_digits;
	struct node* digitList;
} digits;

/** Input: an integer, x.
	Output: struct, digits, containing: 
				- the number of digits in the decimal representation of x
				- a list of the individual digits in x */
digits* get_digits(int x);

/** Input: pointer to a digits struct.
	Side-effects: frees all memory associated with digits. */
void free_digits(digits* ds);

/** Input: a digits struct, ds. 
	Output: the sum of (each digit to the power of the total number of digits).
	Example: 1234 -> 1^4 + 2^4 + 3^4 + 4^4 = 354 */
int sum_powers_of_digits(digits* ds);

/** Input: an integer, x.
	Output: true if x is an Armstrong number:
				x equals the sum of 
				(each digit of x raised to the total number of digits in x)
			false otherwise */
bool is_armstrong_number(int x);

#endif
