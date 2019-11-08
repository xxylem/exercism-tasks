#include "secret_handshake.h"

namespace secret_handshake {

	std::vector<std::string> commands(int n)
	{
		std::vector<std::string> result;
		for (const auto& command : commandValues) {
			if (command.first & n)
				result.push_back(command.second);
		}

		if (16 & n)
			reverse(result.begin(), result.end());

		return result;
	}
}  // namespace secret_handshake
