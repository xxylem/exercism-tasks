#if !defined(RNA_TRANSCRIPTION_H)
#define RNA_TRANSCRIPTION_H

#include <map>
#include <string>

namespace rna_transcription {

	const std::map<char, char> nucleotide_translations = 
	{
		{ 'G', 'C'}
		, {'C', 'G'}
		, {'T', 'A'}
		, {'A', 'U'}
	};

	const char to_rna(const char& nucleotide);
	const std::string to_rna(const std::string& dna_strand);

}  // namespace rna_transcription

#endif // RNA_TRANSCRIPTION_H