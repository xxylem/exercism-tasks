#if !defined(PASCALS_TRIANGLE_H)
#define PASCALS_TRIANGLE_H

#include <vector>

namespace pascals_triangle {

	const std::vector<std::vector<int>> generate_rows(const unsigned int& n);

}  // namespace pascals_triangle

#endif // PASCALS_TRIANGLE_H