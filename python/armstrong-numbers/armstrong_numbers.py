def is_armstrong_number(number):

    digits = str(number)
    num_digits = len(digits)

    armstrong_sum = 0
    for digit in digits:
        armstrong_sum += pow(int(digit), num_digits)

    return armstrong_sum == number
