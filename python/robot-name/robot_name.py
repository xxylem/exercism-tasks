from secrets import choice
from string import ascii_uppercase, digits


class Robot(object):
    names_in_use = set()

    def __init__(self):
        self.name = ""
        self.new_name()

    def reset(self):
        self.new_name()

    def new_name(self):
        random_name = Robot.generate_random_name()

        while random_name in Robot.names_in_use:
            random_name = Robot.generate_random_name()

        Robot.names_in_use.add(random_name)
        self.name = random_name

    @staticmethod
    def generate_random_name():
        random_letters = ''.join([choice(ascii_uppercase) for _ in range(2)])
        random_digits = ''.join([choice(digits) for _ in range(3)])
        random_name = random_letters + random_digits
        return random_name


