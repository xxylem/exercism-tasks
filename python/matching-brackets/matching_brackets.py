import regex as r

def is_paired(input_string):
    """ Returns true if all the brackets in the input string are correctly paired. """

    # Sanitises the string to make the regex match below a lot simpler.
    simplified_string = r.sub(r"[^()\[\]{}]", "", input_string)

    return r.fullmatch(r"(\((?![\]}])(?R)*\)|\[(?![\)}])(?R)*\]|{(?![\])])(?R)*})*", simplified_string) is not None
