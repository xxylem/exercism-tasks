#if !defined(PANGRAM_H)
#define PANGRAM_H

#include <string>

namespace pangram {

	// Assumes that of the characters in sentence, the alphabetic characters are only in [A-Za-z]
	bool is_pangram(const std::string& sentence);

}  // namespace pangram

#endif // PANGRAM_H