#include "sum_of_multiples.h"

namespace sum_of_multiples {
	int to(std::vector<int> factors, int n)
	{
		std::set<int> multiples;

		for (int factor : factors) {
			for (int i = factor; i < n; i += factor)
				multiples.insert(i);
		}

		return std::accumulate(multiples.begin(), multiples.end(), 0);
	}
}  // namespace sum_of_multiples
