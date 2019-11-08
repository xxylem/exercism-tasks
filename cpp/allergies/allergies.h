#if !defined(ALLERGIES_H)
#define ALLERGIES_H

#include <string>
#include <map>
#include <unordered_set>

namespace allergies {

	class allergy_test
	{
	public:
		allergy_test(int score);
		bool is_allergic_to(std::string allergen) const;
		std::unordered_set<std::string> get_allergies() const;

	private:
		const int _score;
		std::unordered_set<std::string> _allergies;

		const std::map<std::string, int> allergenValues = {
		{ "eggs", 1 },
		{ "peanuts", 2 },
		{ "shellfish", 4 },
		{ "strawberries", 8 },
		{ "tomatoes", 16 },
		{ "chocolate", 32 },
		{ "pollen", 64 },
		{ "cats", 128 }
		};
	};

	
}  // namespace allergies

#endif // ALLERGIES_H