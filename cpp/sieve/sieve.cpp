#include "sieve.h"

namespace sieve {
	std::vector<int> primes(int n)
	{

		std::vector<bool> indexIsPrime(n + 1);
		std::fill(indexIsPrime.begin() + 2, indexIsPrime.end(), true);

		indexIsPrime[0] = false;
		indexIsPrime[1] = false;

		for (int i = 2; i <= n; i++) {
			if (indexIsPrime[i]) {
				for (int primeMultiple = i + i; primeMultiple <= n; primeMultiple += i) {
					indexIsPrime[primeMultiple] = false;
				}
			}
		}

		std::vector<int> primes;

		for (int i = 0; i <= n; i++) {
			if (indexIsPrime[i])
				primes.push_back(i);
		}

		return primes;
	}
}  // namespace sieve
