#include "pascals_triangle.h"

namespace pascals_triangle {

	using namespace std;

	const vector<vector<int>> generate_rows(const unsigned int& n)
	{
		switch (n)
		{
		case 0:
			return {};

		case 1: // Base case (n=1).
			return { {1} };

		default: // Inductive step.
			// Recursively generate the rest of the triangle.
			vector<vector<int>> prev_rows = generate_rows(n - 1);

			// Build the current row from the previous row of the triangle.
			const vector<int>& prev_row = prev_rows.back();
			vector<int> current_row;
			current_row.reserve(n);
			current_row.push_back(1);

			for (int i = 0; i < n - 2; i++)
				current_row.push_back(prev_row[i] + prev_row[i + 1]);

			current_row.push_back(1);

			// Add the current row onto the rest of the triangle.
			prev_rows.push_back(current_row);
			return prev_rows;
		}
	}

}  // namespace pascals_triangle
