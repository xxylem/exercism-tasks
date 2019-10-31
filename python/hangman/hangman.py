# Game status categories
# Change the values as you see fit
STATUS_WIN = "win"
STATUS_LOSE = "lose"
STATUS_ONGOING = "ongoing"


class Hangman(object):
    def __init__(self, word):
        self.remaining_guesses = 9
        self.status = STATUS_ONGOING
        self.word = word
        self.letters_left_to_guess = set(word)

    def guess(self, char):
        self.validate_status()

        if char in self.letters_left_to_guess:
            self.letters_left_to_guess.remove(char)
        else:
            self.remaining_guesses -= 1

        self.update_status()

    def validate_status(self):
        if self.status == STATUS_LOSE:
            raise ValueError("No guesses remaining.")

        if self.status == STATUS_WIN:
            raise ValueError("You already won ya dingus!")

    def update_status(self):
        if len(self.letters_left_to_guess) == 0:
            self.status = STATUS_WIN
        elif self.remaining_guesses < 0:
            self.status = STATUS_LOSE

    def get_masked_word(self):
        return "".join(([c if c not in self.letters_left_to_guess else '_' for c in self.word]))

    def get_status(self):
        return self.status
