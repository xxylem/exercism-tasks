# Score categories.
# Change the values as you see fit.
YACHT = 0
ONES = 1
TWOS = 2
THREES = 3
FOURS = 4
FIVES = 5
SIXES = 6
FULL_HOUSE = 7
FOUR_OF_A_KIND = 8
LITTLE_STRAIGHT = 9
BIG_STRAIGHT = 10
CHOICE = 11


def full_house_rule(sorted_dice):
    if (sorted_dice[0] != sorted_dice[4]) and \
            ((sorted_dice[0] == sorted_dice[2] and sorted_dice[3] == sorted_dice[4])
             or (sorted_dice[0] == sorted_dice[1] and sorted_dice[2] == sorted_dice[4])):
        return sum(sorted_dice)
    else:
        return 0


def four_of_a_kind_rule(sorted_dice):
    if sorted_dice[0] == sorted_dice[3]:
        return sum(sorted_dice[0:4])
    elif sorted_dice[1] == sorted_dice[4]:
        return sum(sorted_dice[1:])
    else:
        return 0


scoring_rules = {
    YACHT: lambda sorted_dice: 50 if sorted_dice[0] == sorted_dice[4] else 0,
    ONES: lambda sorted_dice: sum([die for die in sorted_dice if die is 1]),
    TWOS: lambda sorted_dice: sum([die for die in sorted_dice if die is 2]),
    THREES: lambda sorted_dice: sum([die for die in sorted_dice if die is 3]),
    FOURS: lambda sorted_dice: sum([die for die in sorted_dice if die is 4]),
    FIVES: lambda sorted_dice: sum([die for die in sorted_dice if die is 5]),
    SIXES: lambda sorted_dice: sum([die for die in sorted_dice if die is 6]),
    FULL_HOUSE: full_house_rule,
    FOUR_OF_A_KIND: four_of_a_kind_rule,
    LITTLE_STRAIGHT: lambda sorted_dice: 30 if len(set(sorted_dice)) == len(sorted_dice)
                                               and sorted_dice[0] == 1 and sorted_dice[4] == 5 else 0,
    BIG_STRAIGHT: lambda sorted_dice: 30 if len(set(sorted_dice)) == len(sorted_dice)
                                               and sorted_dice[0] == 2 and sorted_dice[4] == 6 else 0,
    CHOICE: sum,
}


def score(dice, category):
    return scoring_rules[category](sorted(dice))
