def convert(number):
    """ Converts number to string representation of its "sound",
        using messages already provided to add_new_factor_message."""

    return "".join([fac_fun(number) for fac_fun in factor_message_functions]) or str(number)


def add_new_factor_message(factor, message):
    factor_message_functions.append(
        lambda x: message if x % factor == 0 else "")


factor_message_functions = []
add_new_factor_message(3, "Pling")
add_new_factor_message(5, "Plang")
add_new_factor_message(7, "Plong")
