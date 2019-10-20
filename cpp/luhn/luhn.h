#if !defined(LUHN_H)
#define LUHN_H

#include <string>

namespace luhn {

	const bool valid(const std::string& number);

}  // namespace luhn

#endif // LUHN_H