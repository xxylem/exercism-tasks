#if !defined(NUCLEOTIDE_COUNT_H)
#define NUCLEOTIDE_COUNT_H

#include <map>
#include <string>

namespace nucleotide_count {

	class counter
	{
	public:

		counter(std::string dna_strand);
		std::map<char, int> nucleotide_counts(void) const;
		int count(const char nucleotide) const;

	private:

		std::map<char, int> m_nucleotide_count;
		const std::string valid_nucleotides = "ATCG";
		bool is_valid_nucleotide(const char nucleotide) const;

	};

}  // namespace nucleotide_count

#endif // NUCLEOTIDE_COUNT_H