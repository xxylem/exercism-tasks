#include "rna_transcription.h"

namespace rna_transcription {

	using namespace std;

	const char to_rna(const char& nucleotide)
	{
		return nucleotide_translations.at(nucleotide);
	}

	const string to_rna(const string& dna_strand)
	{
		string rna_strand;

		for (const char& nucleotide : dna_strand)
			rna_strand += to_rna(nucleotide);

		return rna_strand;
	}
}  // namespace rna_transcription
