#include "isogram.h"
#include <string>
#include <map>


namespace isogram {

	using namespace std;

	const bool is_isogram(const string& word) {
		
		map<char, bool> seen_letters;
		
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
