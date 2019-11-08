#include "allergies.h"

namespace allergies {
	   
	allergy_test::allergy_test(int score) : _score(score) {

		for (const auto& allergen : allergenValues) {
			if (allergen.second & score)
				_allergies.insert(allergen.first);
		}
	};
	
	bool allergy_test::is_allergic_to(std::string allergen) const
	{
		return allergenValues.at(allergen) & _score;
	}

	std::unordered_set<std::string> allergy_test::get_allergies() const
	{
		return _allergies;
	}

}  // namespace allergies
