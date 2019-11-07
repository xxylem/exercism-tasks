#include "queen_attack.h"
#include <stdexcept>

namespace queen_attack {

	chess_board::chess_board() :
		chess_board(std::make_pair(0, 3), std::make_pair(7, 3)) {}
	
	chess_board::chess_board(std::pair<int, int> white, std::pair<int, int> black)
	{
		if (white == black)
			throw std::domain_error("Queens may not occupy the same square.");

		_white = white;
		_black = black;

		_board = {
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n"
			"_ _ _ _ _ _ _ _\n" };

		_board[(__int64)_white.first * 16 + (__int64)_white.second * 2] = 'W';
		_board[(__int64)_black.first * 16 + (__int64)_black.second * 2] = 'B';

	}

	const std::pair<int, int> chess_board::white() const { return _white; }
	const std::pair<int, int> chess_board::black() const { return _black; }

	bool chess_board::can_attack() const
	{
		return _white.first == _black.first // Same row
			|| _white.second == _black.second // Same column
			// Same NW-SE diagonal
			|| _white.first - _black.first == _white.second - _black.second
			// Same NE-SW diagonal
			|| _white.first + _white.second == _black.first + _black.second;
	}


}  // namespace queen_attack
