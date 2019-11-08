#if !defined(SECRET_HANDSHAKE_H)
#define SECRET_HANDSHAKE_H

#include <algorithm>
#include <vector>
#include <string>
#include <map>

namespace secret_handshake {

	const std::map<int, std::string> commandValues = {
		{ 1, "wink"},
		{ 2, "double blink"},
		{ 4, "close your eyes"},
		{ 8, "jump"}
	};

	std::vector<std::string> commands(int n);

}  // namespace secret_handshake

#endif // SECRET_HANDSHAKE_H
