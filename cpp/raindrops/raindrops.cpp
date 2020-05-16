#include "raindrops.h"
#include <vector>

namespace raindrops {

	struct Drop
	{
		int factor;
		std::string text;
	};

	static std::vector<Drop> drops = {
		{ 3, "Pling"},
		{ 5, "Plang"},
		{ 7, "Plong"}
	};

	std::string convert(int n)
	{
		std::string convertedText = "";

		for (auto drop : drops)
		{
			if (n % drop.factor == 0)
			{
				convertedText += drop.text;
			}
		}

		return convertedText == "" ? std::to_string(n) : convertedText;
	}

}  // namespace raindrops
