from sympy import divisors, sqrt


def classify(number):
    if number < 1:
        raise ValueError("number must be a natural number.")

    # aliquot_sum = sum(divisors(number)[:-1])  # Uses Sympy library.
    aliquot_sum = sum(factors(number)[:-1])     # Uses method below.

    if aliquot_sum == number:
        return "perfect"
    elif aliquot_sum > number:
        return "abundant"
    return "deficient"


def factors(number):
    small_factors_found = []
    large_factors_found = []
    for i in range(1, int(sqrt(number) + 1)):
        if number % i == 0:
            small_factors_found.append(i)
            if i * i != number:
                large_factors_found.append(number // i)
    large_factors_found.reverse()
    return small_factors_found + large_factors_found
