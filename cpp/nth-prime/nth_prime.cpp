#include "nth_prime.h"



namespace nth_prime {

	int nth(int n)
	{
		if (n < 1)
			throw std::domain_error("Only defined on positive integers.");

		// Handle 2 separately to avoid all even numbers in loop below.
		std::vector<int> primes_found = { 2 };
		n--;
		int last_prime = 2;
		
		for (int candidate = 3; n > 0; candidate += 2) {

			if (all_of(primes_found.begin(), primes_found.end(),
				[candidate](int prime) {
					return candidate % prime != 0;
				})) 
			{
				primes_found.push_back(candidate);
				n--;
				last_prime = candidate;
			}
		}

		return last_prime;
	}

}  // namespace nth_prime
