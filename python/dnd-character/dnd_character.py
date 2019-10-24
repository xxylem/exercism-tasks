import secrets


def modifier(constitution):
    return (constitution - 10) // 2

class Character:
    def __init__(self):
        self.strength = Character.ability()
        self.dexterity = Character.ability()
        self.constitution = Character.ability()
        self.intelligence = Character.ability()
        self.wisdom = Character.ability()
        self.charisma = Character.ability()
        self.hitpoints = 10 + modifier(self.constitution)

    @staticmethod
    def ability():
        four_random_rolls = [1 + secrets.randbelow(6) for _ in range(4)]
        return sum(sorted(four_random_rolls)[1:])