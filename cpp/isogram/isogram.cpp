#include "isogram.h"
#include <string>
#include <map>


namespace isogram {

	bool is_isogram(std::string word) {
		
		std::map<char, bool> seen_letters;
		
		for (char c : word) {

			c = tolower(c);
			if (isalpha(c)) {
				if (seen_letters[c]) {
					return false;
				}
				seen_letters[c] = true;
			}
		}

		return true;
	}

}  // namespace isogram
