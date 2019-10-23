from math import floor, sqrt, hypot, isclose

def triplets_with_sum(number):
    triplets = []

    start = 1
    end = number // 2 + 1

    for x in range(start, end):
        y_window_start = x + 1
        y_window_end = end
        y_window_size = y_window_end - y_window_start

        while y_window_size > 1:

            y_window_midpoint = (y_window_start + y_window_end) // 2
            y = y_window_midpoint

            z = hypot(x, y)

            if isclose(y, z, rel_tol=1e-10):
                break

            result = x + y + z
            if isclose(result, number, rel_tol=1e-10):
                triplets.append([x, y, int(z + 0.5)])
                break
            elif result < number:
                y_window_start = y_window_midpoint
            else:
                y_window_end = y_window_midpoint

            y_window_size = y_window_end - y_window_start

        if y_window_size == 1:
            y = y_window_start
            z = hypot(x, y)

            if isclose(y, z, rel_tol=1e-10):
                break

            result = x + y + z
            if isclose(result, number, rel_tol=1e-10):
                triplets.append([x, y, int(z + 0.5)])

            y = y_window_end
            z = hypot(x, y)

            if isclose(y, z, rel_tol=1e-10):
                break

            result = x + y + z
            if isclose(result, number, rel_tol=1e-10):
                triplets.append([x, y, int(z + 0.5)])



    return triplets
