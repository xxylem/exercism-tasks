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
    return r.match(r"^\(.*\)$", input_string, flags=r.DOTALL) is not None


def __parse_tree(input_string):
    """ Input: a SgfTree in string representation, including outer parentheses.
        Output: the SgfTree
        NOTE: Only a single tree is valid. If you have multiple together, such as
                (;B[C])(;C[D]), they must be split first using split_up_variations(). """

    # An SGF tree comprises some number of single nodes, e.g. ;A[B];B[C], optionally
    # followed by some number of variations, e.g. (;B[C])(;C[D]). Here, we split up
    # these two parts of the tree.
    m = r.fullmatch(r"\((?<single_nodes>(?:;[^();]*)+)(?<variations>.*)\)", input_string, flags=r.DOTALL)

    if m is None:
        raise ValueError("Tree has no nodes.")

    single_nodes = m.group("single_nodes")
    variations = m.group("variations")

    # We deal with all the single nodes at the start. This makes a very thin tree.
    tree_root, last_child = __parse_single_nodes(single_nodes)

    if len(variations) == 0:
        return tree_root

    # Then we deal with any variations. Since these are full trees, we can split them
    # up and recurse on each separately. Finally, we add them as children to the last
    # child in the tree of single nodes.
    variations = __split_up_variations(variations)
    variation_trees = [__parse_tree(variation) for variation in variations]
    last_child.children = variation_trees
    return tree_root


def __split_up_variations(input_string):
    """ Input: the string representation of child trees in sequence.
        Output: a list of the string representations separated.
        E.g.: '(;B[C])(;C[D])' -> ['(;B[C])', '(;C[D])'] """
    return r.findall(r"(\([^()]*\))", input_string, flags=r.DOTALL)


def __parse_single_nodes(single_nodes: str):
    """ Input: the string representation of a sequence of single nodes, each of which
              is the direct child of the one immediately before it.
        Output: tree_root, the full SgfTree consisting of all nodes where the leftmost
                node in the input is the tree root.
                last_child, the final child in the tree, which is the rightmost string in
                the input.
        E.g.: ;A[B];B[C];D[asd];F[foo]
                ^                  ^
                |                  |
            tree_root           last_child """
    single_nodes = r.findall(r";([^();]*)", single_nodes, flags=r.DOTALL)
    parsed_nodes = [__parse_node(node) for node in single_nodes]

    # There is only one node, which is both the tree_root and the last_child.
    if len(parsed_nodes) == 1:
        return parsed_nodes[0], parsed_nodes[0]

    tree_root = parsed_nodes[0]
    last_child = parsed_nodes[-1]
    child_node = last_child
    # Makes each node the child of the node before it.
    for node in parsed_nodes[-2::-1]:
        node.children = [child_node]
        child_node = node

    return tree_root, last_child


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
