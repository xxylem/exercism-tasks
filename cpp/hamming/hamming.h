#if !defined(HAMMING_H)
#define HAMMING_H

#include <string>

namespace hamming {

	int compute(const std::string& left_strand, const std::string& right_strand);

}  // namespace hamming

#endif // HAMMING_H