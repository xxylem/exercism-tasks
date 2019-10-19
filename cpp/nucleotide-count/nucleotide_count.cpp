#include "nucleotide_count.h"
#include <stdexcept>

using namespace std;

namespace nucleotide_count {

	counter::counter(string dna_strand) 
	{
		m_nucleotide_count = { {'A', 0}
							 , {'T', 0}
							 , {'C', 0}
							 , {'G', 0} };
		
		for (char nucleotide : dna_strand) 
		{
			if (!is_valid_nucleotide(nucleotide))
				throw invalid_argument("Strand contains an invalid nucleotide.");
			m_nucleotide_count[nucleotide]++;
		}
	}

	std::map<char, int> counter::nucleotide_counts(void) const 
	{
		return m_nucleotide_count;
	}

	int counter::count(const char nucleotide) const
	{
		if (!is_valid_nucleotide(nucleotide))
			throw invalid_argument("That is not a valid nucleotide.");

		return m_nucleotide_count.at(nucleotide);
	}

	bool counter::is_valid_nucleotide(const char nucleotide) const
	{
		return valid_nucleotides.find(nucleotide) != string::npos;
	}

}  // namespace nucleotide_count
