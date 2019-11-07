#include "sieve.h"

namespace sieve {
	std::vector<int> primes(int n)
	{
		std::vector<bool> indexIsPrime(n + 1, true);

		indexIsPrime[0] = false;
		indexIsPrime[1] = false;

		std::vector<int> primes;

		for (int i = 2; i <= n; i++) {
			if (indexIsPrime[i]) {

				primes.push_back(i);

				// Sieve out multiples of this prime.
				for (int primeMultiple = i + i; primeMultiple <= n; primeMultiple += i) {
					indexIsPrime[primeMultiple] = false;
				}
			}
		}

		return primes;
	}
}  // namespace sieve
