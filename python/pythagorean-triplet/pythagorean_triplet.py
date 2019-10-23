from math import hypot, isclose


def triplets_with_sum(target_number):
    """ Returns all pythagorean triplets whose sum of sides a, b, c is target_number """

    def helper(b_min, b_max):
        """ Searches for a pythagorean triplet given the fixed side 'a' whose
            sum of sides is target_number. """
        nonlocal a
        # Uses divide and conquer.
        # Takes the midpoint of the possible range of side 'b'.
        b = (b_min + b_max) // 2
        c = hypot(a, b)

        # We discard the defective triplet that has b = c.
        if isclose(b, c, rel_tol=1e-10):
            return []

        # Checks if this combination of a, b and c are the desired triplet.
        # Implicitly, c must be very close (within 1e-10) to an integer for this to hold,
        # since a and b are both integers.
        sum_of_sides = a + b + c
        if isclose(sum_of_sides, target_number, rel_tol=1e-10):
            return [a, b, int(c + 0.5)]

        # Base case (n=1): the only possible 'b' left in the range failed. We are done.
        if b_min == b_max:
            return []

        # Base case (n=2): There are two possible side 'b's. The integer division above
        # picks the first one. This makes sure to try the second one.
        if abs(b_max - b_min) == 1:
            return helper(b_max, b_max)

        # We need to look in the second half of the range of 'b's.
        if sum_of_sides < target_number:
            return helper(b, b_max)
        # We need to look in the first half of the range of 'b's.
        else:
            return helper(b_min, b)

    triplets = []
    # Side a cannot be larger than half the target number because:
    #       a + b + c = target_number
    # and   a**2 + b**2 = c**2
    # <==>  a + b + sqrt(a**2 + b**2) = target_number
    # This describes a curve that is bounded in the first quadrant by the x and y axes.
    # If a = 0, b + sqrt(b**2) = target_number; b = target_number / 2
    # If b = 0, a + sqrt(a**2) = target_number; a = target_number / 2
    # So, a and b must be integers in (0, target_number / 2)
    end = target_number // 2 + 1

    # We see if there is a pythagorean triplet for each 'a' in the range that
    # has the desired sum.
    for a in range(1, end):
        triplet = helper(a + 1, end)
        if triplet:
            triplets.append(triplet)

    return triplets
