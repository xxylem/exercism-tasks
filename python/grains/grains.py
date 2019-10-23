def square(number):

    if number < 1 or number > 64:
        raise ValueError("Square number must be between 1 and 64")

    return 1 << number - 1


def total(number):
    if number < 1:
        raise ValueError("Square number must be between 1 and 64")

    return sum([square(x) for x in range(1, number + 1)])
