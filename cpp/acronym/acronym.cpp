#include "acronym.h"

namespace acronym {

	using namespace std;

	const string acronym(const string& long_name)
	{
		string abbreviated_name;
		abbreviated_name.reserve(4); // Assume most acronyms are 3-4 letters.
		abbreviated_name += long_name.front();
		const int n = long_name.size() - 1;

		for (int i = 1; i < n; i++)
		{
			const char& previous_char = long_name.at(i - 1);
			const char& current_char = long_name.at(i);

			if (!isalpha(previous_char))
				if (isalpha(current_char))
					abbreviated_name += toupper(current_char);
		}

		return abbreviated_name;
	}

}  // namespace acronym
