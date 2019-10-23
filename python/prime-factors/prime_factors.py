import numpy as np
from sympy.ntheory import factorint


def factors(value):
    """ Returns prime factorisation of the given positive integer. """
    # return factors_using_library(value)
    return factors_no_number_theory_library(value)


def factors_no_number_theory_library(value):
    """ Returns prime factorisation of the given positive integer. """
    factors_found = []
    for prime in primes_up_to_inclusive(value):
        # Try to divide out as many of this prime factor as possible.
        while value % prime == 0 and value > 1:
            value //= prime
            factors_found.append(prime)

        if value == 1:
            break
    return factors_found


def primes_up_to_inclusive(n):
    """ A generator that provides primes up to and including the given value n."""

    # I handle two separately so that I don't have to include even numbers from the start.
    yield 2
    primes = [2]

    # I run the sieve in segments. My computer doesn't have much memory and it runs out
    # if I try to sieve everything at once on large numbers.
    start = 3
    stop = min(1000, n)

    # Only generates odd numbers
    potentials = np.arange(start=start, stop=stop, step=2)

    while potentials.size > 0:
        while potentials.size > 0:
            new_prime = potentials[0]
            # I yield here to avoid doing unnecessary computation.
            # Maybe the caller only needs up to this prime.
            yield new_prime
            primes.append(new_prime)

            # This sieves out all natural numbers that are multiples of this prime.
            potentials = potentials[potentials % new_prime != 0]

        # If I run out of potentials, this gets some more.
        start = stop
        if start % 2 == 0:
            start -= 1
        stop = min(start + 1000, n)
        potentials = np.arange(start=start, stop=stop, step=2)

    return primes


# This version simply makes use of Sympy's number theory library. This is what I would
# use in a real-life case rather than writing everything from scratch.
def factors_using_library(value):
    """ Returns prime factorisation of the given positive integer. """
    factors_found = []
    for (factor, multiplicity) in factorint(value).items():
        factors_found += ([factor] * multiplicity)
    return factors_found
