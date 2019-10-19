#include "scrabble_score.h"

namespace scrabble_score {

	const int score(const std::string& word)
	{
		int word_score = 0;

		for (const char& letter : word)
			word_score += letter_scores.at(toupper(letter));

		return word_score;
	}

}  // namespace scrabble_score
