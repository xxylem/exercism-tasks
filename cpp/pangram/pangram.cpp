#include "pangram.h"
#include <bitset>
#include <cctype>

namespace pangram {

	bool is_pangram(const std::string& sentence)
	{
		// letters_found[i] is true (set) when the ith letter (0-based) of the English alphabet has been found in sentence, false otherwise.
		std::bitset<26> letters_found;

		for (auto c : sentence)
		{
			if (std::isalpha(c))
			{
				int alpha_index = std::tolower(c) - 'a';
				letters_found.set(alpha_index);
			}
		}

		return letters_found.all();
	}

}  // namespace pangram
