def recite(start_verse, end_verse):
    return [verse(n) for n in range(start_verse, end_verse + 1)]


# Assumes 1 <= number <= 12
def verse(number):
    return verse_start(number) + verse_end(number)


def verse_start(number):
    return "On the " + ordinal_numbers[number] + " day of Christmas my true love gave to me: "


def verse_end(number):
    gifts_str = ", ".join(gifts[number - 1:0:-1])
    if number > 1:
        gifts_str += ", and "
    gifts_str += gifts[0] + '.'
    return gifts_str


ordinal_numbers = {
    1: "first",
    2: "second",
    3: "third",
    4: "fourth",
    5: "fifth",
    6: "sixth",
    7: "seventh",
    8: "eighth",
    9: "ninth",
    10: "tenth",
    11: "eleventh",
    12: "twelfth"
}

gifts = [
    "a Partridge in a Pear Tree",
    "two Turtle Doves",
    "three French Hens",
    "four Calling Birds",
    "five Gold Rings",
    "six Geese-a-Laying",
    "seven Swans-a-Swimming",
    "eight Maids-a-Milking",
    "nine Ladies Dancing",
    "ten Lords-a-Leaping",
    "eleven Pipers Piping",
    "twelve Drummers Drumming"
]
