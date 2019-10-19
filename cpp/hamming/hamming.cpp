#include "hamming.h"
#include <stdexcept>

namespace hamming {

	using namespace std;

	int compute(const string& left_strand, const string& right_strand) {

		if (left_strand.length() != right_strand.length())
			throw domain_error("Strands must have the same length");

		size_t len = left_strand.length();
		int distance = 0;
		
		for (int i = 0; i < len; i++)
			if (left_strand[i] != right_strand[i])
				distance++;
		
		return distance;
	}

}  // namespace hamming
