#if !defined(QUEEN_ATTACK_H)
#define QUEEN_ATTACK_H

#include <string>
#include <utility>

namespace queen_attack {

	class chess_board
	{
	public:
		chess_board();
		chess_board(std::pair<int, int> white, std::pair<int, int> black);

		const std::pair<int, int> white() const;
		const std::pair<int, int> black() const;

		operator std::string() const { return _board; }

		bool can_attack() const;

	private:
		std::pair<int, int> _white;
		std::pair<int, int> _black;
		std::string _board;
	};

	


}  // namespace queen_attack

#endif // QUEEN_ATTACK_H