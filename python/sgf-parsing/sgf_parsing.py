from typing import List

import regex as r


class SgfTree(object):
    def __init__(self, properties=None, children=None):
        self.properties = properties or {}
        self.children = children or []

    def __eq__(self, other):
        if not isinstance(other, SgfTree):
            return False
        for k, v in self.properties.items():
            if k not in other.properties:
                return False
            if other.properties[k] != v:
                return False
        for k in other.properties.keys():
            if k not in self.properties:
                return False
        if len(self.children) != len(other.children):
            return False
        for a, b in zip(self.children, other.children):
            if a != b:
                return False
        return True

    def __ne__(self, other):
        return not self == other


def parse(input_string):
    """ Input: a valid SgfTree in string representation.
        Output: the SgfTree """

    # These checks only need to be performed once at the start.
    if len(input_string) == 0:
        raise ValueError("Empty input.")
    if not __has_outer_parentheses(input_string):
        raise ValueError("Input is not a recognised tree. Outer parentheses are missing.")

    return __parse_tree(input_string)


def __has_outer_parentheses(input_string):
    """ Checks that the string starts and ends with parentheses. """
    return r.match(r"\(.*\)", input_string, flags=r.DOTALL) is not None


def __parse_tree(input_string):
    """ Input: a SgfTree in string representation, optionally prepended by some number
                of single nodes.
        Output: the SgfTree
        NOTE: Only a single tree is valid. If you have multiple together, such as
                (;B[C])(;C[D]), they must be split first using split_up_children(). """
    # The outer parentheses may not exist because we also recursively call the
    # method on subtrees
    input_string = strip_outer_parentheses(input_string)
    m = r.fullmatch(r";(?<root_node>[^();]*)(?<rest>.*)", input_string, flags=r.DOTALL)

    if m is None:
        raise ValueError("Tree has no nodes.")

    root_node = m.group("root_node")
    rest = m.group("rest")

    # Makes tree with no children with all the properties that the current node has.
    tree = __parse_node(root_node)

    # In this case, there are no children (neither single nor multiple variations)
    if len(rest) == 0:
        return tree

    # If the rest starts with a node, we recurse on the rest and add the result
    # as the only child of the current node.
    if __starts_with_node(rest):
        tree.children = [__parse_tree(rest)]
        return tree

    # The rest must either a full tree or multiple trees in sequence.
    # They are all direct children of the current node.
    children = __split_up_children(rest)
    children_trees = [__parse_tree(child) for child in children]
    tree.children = children_trees
    return tree


def strip_outer_parentheses(input_string):
    return r.sub(r"^\((?<inner>.*)\)$", r"\g<inner>", input_string, flags=r.DOTALL)


def __split_up_children(input_string):
    """ Input: the string representation of child trees in sequence.
        Output: a list of the string representations separated.
        E.g.: '(;B[C])(;C[D])' -> ['(;B[C])', '(;C[D])'] """
    return r.findall(r"(?:\(([^()]*)\))", input_string, flags=r.DOTALL)


def __starts_with_node(input_string):
    return input_string[0] == ";"


def __parse_node(node: str):
    """ Input: a single node of the tree.
        Output: an SgfTree with the node's properties and no children.
        ASSUMES: the leading semicolon has already been removed.
        E.g.: "A[b]C[d]" ->
                SgfTree(properties={"A": ["b"], "C": ["d"]})"""
    tree = SgfTree()
    properties = r.findall(r"[A-Z]+(?:\[.*?(?<!\\)\])+", node, flags=r.DOTALL)

    if len(properties) == 0 and len(node) > 0:
        raise ValueError("Failed to parse property.")

    tree.properties = __parse_properties(properties)
    return tree


def __parse_properties(properties: List[str]):
    """ Input: a list of properties to be parsed.
        Output: a dictionary containing all the properties.
        E.g: ['A[foo][bar]', 'C[d]'] -> {'A': ['foo', 'bar'], 'C: ['d']} """
    properties_dict = {}
    for prop in properties:
        m = r.fullmatch(r"(?<Key>[A-Z]+)(?<valueList>(?:\[.+?(?<!\\)\])+)", prop, flags=r.DOTALL)
        key = m.group("Key")
        value_list = m.group("valueList")
        value_list = __parse_value_list(value_list)
        properties_dict[key] = value_list
    return properties_dict


def __parse_value_list(value_list: str):
    """ Input: a string of values each bounded by square brackets.
        Output: a list of the values, without square brackets.
        E.g.: "[foo][bar][c]" ->  ["foo", "bar", "c"] """

    values = r.findall(r"\[(?<value>.*?)(?<!\\)\]", value_list, flags=r.DOTALL)
    return [__clean_property_value(value) for value in values]


def __clean_property_value(property_value: str):
    """ Input: an already parsed property value.
            Sanitises special characters in the value.
            Converts tab characters to spaces and removes escape characters before
            close brackets.
        E.g.: "(;A[\]b\nc\nd\t\te \n\]])" -> "]b\nc\nd  e \n]" """
    # For some reason tabs in the input string must be spaces in the output value.
    # Newline characters are unaffected.
    property_value = r.sub(r"\t", " ", property_value, flags=r.DOTALL)
    # This is a little 'hacky'. For some reason the test cases do not use raw strings,
    # which means Python inserts an extra backslash before \], because \] is not a valid
    # escape sequence. So we have to remove two backslashes, not just one.
    property_value = r.sub(r"\\(?=\\)|\\(?=\])", "", property_value, flags=r.DOTALL)
    return property_value
