def sum_of_multiples(limit, multiples):

    return sum([x for x in range(limit) if any([x % m == 0 for m in multiples if m != 0])])
