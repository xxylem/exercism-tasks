FACTOR_MESSAGES = [
    (3, "Pling"),
    (5, "Plang"),
    (7, "Plong")]


def convert(number):
    """ Converts number to string representation of its "sound",
        using messages already provided to add_new_factor_message."""

    return "".join([message if number % factor == 0 else "" for (factor, message) in FACTOR_MESSAGES]) or str(number)



