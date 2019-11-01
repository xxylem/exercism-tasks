def slices(series, length):
    if len(series) == 0:
        raise ValueError("Series must have positive length.")
    if length < 1:
        raise ValueError("Slice length must be positive.")
    if length > len(series):
        raise ValueError("Slice length must be at most the series length.")

    return [series[x:x+length] for x in range(len(series) - length + 1)]
