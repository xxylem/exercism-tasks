#include "collatz_conjecture.h"
#include <stdexcept>

namespace collatz_conjecture {
	int steps(int n)
	{
		if (n < 1)
			throw std::domain_error("Only defined on positive integers.");

		// Base case
		if (n == 1)
			return 0;

		// Inductive step (n even)
		if (n % 2 == 0)
			return 1 + steps(n / 2);

		// Inductive step (n odd)
		return 1 + steps(3 * n + 1);
	}
}  // namespace collatz_conjecture
