#include "armstrong_numbers.h"
#include <math.h>
#include <stdlib.h>

digits * get_digits(int x) {

	// Allocate memory for new digits struct.
	digits * ds;
	ds = malloc(sizeof(digits));
	if (!ds) {
		return NULL;
	}

	// The digits of a negative number are the same as its positive equivalent.
	x = abs(x);

	// 'Manually' add first digit
	//	This helps with the case x = 0
	//  and allows us to set up the head of the digit list.
	ds->number_of_digits = 1;
	ds->digitList = malloc(sizeof(node));
	if (!(ds->digitList)) {
		return NULL;
	}
	// Get the rightmost digit of x.
	ds->digitList->val = x % 10;
	// Remove the rightmost digit.
	x /= 10;
	ds->digitList->next = NULL;
	

	node* current = ds->digitList;
	node* new_node = NULL;
	// While there are digits in x.
	while (x > 0) {
		new_node = malloc(sizeof(node));
		if (!new_node) {
			free(ds);
			return NULL;
		}

		// Add the rightmost digit of x to the list.
		new_node->val = x % 10;
		new_node->next = NULL;

		current->next = new_node;
		current = current->next;

		// Remove the rightmost digit from x.
		ds->number_of_digits++;
		x /= 10;
	}

	return ds;
}

int sum_powers_of_digits(digits* ds) {
	int sum = 0;
	int num_digits = ds->number_of_digits;
	
	node* current = ds->digitList;

	while (current) {
		// Add the current digit to the power of the number of digits
		//   to the cumulative sum.
		sum += (int) (pow(current->val, num_digits) + 0.5);
		current = current->next;
	}

	return sum;
}

void free_digits(digits* ds) {

	// Free the list of digits.
	node* current = ds->digitList;
	while (current) {
		node* temp = current;
		current = current->next;
		free(temp);
	}
	ds->digitList = NULL;

	// Free the digits struct.
	free(ds);
}

bool is_armstrong_number(int x)
{
	// Get a list of the digits of x and the total number of digits.
	digits* ds = get_digits(x);
	if (!ds) {
		return -1;
	}

	// Calculate the sum of (each digit raised to the power of the total number of digits.)
	int sum = sum_powers_of_digits(ds);

	free_digits(ds);

	return sum == x;
}
