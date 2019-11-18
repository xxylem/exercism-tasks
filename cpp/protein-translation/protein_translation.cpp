#include "protein_translation.h"
#include <map>

namespace protein_translation {

	bool is_stop(const std::string& codon) {
		return codon == "UAA" || codon == "UAG" || codon == "UGA";
	}

	static const std::map<std::string, std::string> translate = {
		{ "AUG", "Methionine"},
		{ "UUU", "Phenylalanine"}, {"UUC", "Phenylalanine"},
		{ "UUA", "Leucine"}, { "UUG", "Leucine"},
		{ "UCU", "Serine"}, { "UCC", "Serine"}, { "UCA", "Serine"}, { "UCG", "Serine"},
		{ "UAU", "Tyrosine"}, { "UAC", "Tyrosine"},
		{ "UGU", "Cysteine"}, { "UGC", "Cysteine"},
		{ "UGG", "Tryptophan"}
	};

	std::vector<std::string> proteins(const std::string& codon_sequence)
	{
		std::vector<std::string> proteins_found;
		for (int i = 0; i <= codon_sequence.length() - 3; i += 3) {
			std::string codon = codon_sequence.substr(i, 3);

			if (is_stop(codon))
				return proteins_found;

			proteins_found.push_back(translate.at(codon));
		}

		return proteins_found;
	}
}  // namespace protein_translation
