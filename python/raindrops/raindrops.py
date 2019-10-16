def convert(number):
    """ Converts number to string representation of its "sound",
        using messages already provided to add_new_factor_message."""

    return "".join([message if number % factor == 0 else "" for (factor, message) in factor_messages]) or str(number)


factor_messages = [
    (3, "Pling"),
    (5, "Plang"),
    (7, "Plong")]
