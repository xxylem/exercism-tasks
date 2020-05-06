def recite(start_verse, end_verse):
    return [verse(n) for n in range(start_verse, end_verse + 1)]


# Assumes 1 <= number <= 12
def verse(number):
    if number == 1:
        # Special case, easier just to hard-code.
        return "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree."

    return "On the " + ordinal_numbers[number] + " day of Christmas my true love gave to me: " + \
           "".join(gifts[number - 1::-1])


ordinal_numbers = {
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
    "and a Partridge in a Pear Tree.",
    "two Turtle Doves, ",
    "three French Hens, ",
    "four Calling Birds, ",
    "five Gold Rings, ",
    "six Geese-a-Laying, ",
    "seven Swans-a-Swimming, ",
    "eight Maids-a-Milking, ",
    "nine Ladies Dancing, ",
    "ten Lords-a-Leaping, ",
    "eleven Pipers Piping, ",
    "twelve Drummers Drumming, "
]
