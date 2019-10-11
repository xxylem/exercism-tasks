def convert(number):
    """ Converts number to string representation of its "sound",
        s.t. if number:
            has 3 as a factor, add 'Pling' to the result.
            has 5 as a factor, add 'Plang' to the result.
            has 7 as a factor, add 'Plong' to the result.
            does not have any of 3, 5, or 7 as a factor, the result should be the digits of the number."""

    sound = ""

    if number % 3 == 0:
        sound += "Pling"
    if number % 5 == 0:
        sound += "Plang"
    if number % 7 == 0:
        sound += "Plong"
    if not sound:
        sound = str(number)

    return sound
