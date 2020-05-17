LETTER_VALUES = {
    'A': 1, 'E': 1, 'I': 1, 'O': 1, 'U': 1, 'L': 1, 'N': 1, 'R': 1, 'S': 1, 'T': 1,
    'D': 2, 'G': 2,
    'B': 3, 'C': 3, 'M': 3, 'P': 3,
    'F': 4, 'H': 4, 'V': 4, 'W': 4, 'Y': 4,
    'K': 5,
    'J': 8, 'X': 8,
    'Q': 10, 'Z': 10
}


def score(word):
    """
    :param word: word to score, should only contain chars in [A-Za-z]
    :return: Scrabble score of word, e.g. "cabbage" scores 14 points:
                3 points for C,
                1 point for A (twice),
                3 points for B (twice),
                2 points for G,
                1 point for E.
    """
    return sum([LETTER_VALUES[c] for c in word.upper()])
