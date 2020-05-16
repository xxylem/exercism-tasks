#include "pangram.h"
#include <bitset>

namespace pangram {

	bool is_pangram(const std::string& sentence)
	{
		// letters_found[i] is true (set) when the ith letter (0-based) of the English alphabet has been found in sentence, false otherwise.
		std::bitset<26> letters_found;

		for (const auto& c : sentence)
		{
			if (isalpha(c))
			{
				int alpha_index = tolower(c) - 'a';
				letters_found.set(alpha_index);
			}
		}

		return letters_found.all();
	}

}  // namespace pangram
