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

    if len(input_string) == 0:
        raise ValueError("Empty input.")

    if not is_tree(input_string):
        raise ValueError("Input is not a recognised tree. Maybe outer parentheses are missing.")

    tree = parse_tree(input_string)

    return tree

def is_tree(input_string):
    return r.fullmatch(r"^\(.*\)$", input_string, flags=r.DOTALL) is not None

def parse_tree(input_string):

    while is_tree(input_string):
        input_string = r.sub(r"^\((?<inner>.*)\)$", r"\g<inner>", input_string, flags=r.DOTALL)

    m = r.fullmatch(r";(?<root_node>[^();]*)(?<rest>.*)", input_string, flags=r.DOTALL)

    if m is None:
        raise ValueError("Tree has no nodes.")

    root_node = m.group("root_node")
    rest = m.group("rest")

    tree = parse_root_node(root_node)
    if len(rest) == 0:
        return tree

    if node_is_next(rest):
        rest_of_tree = parse_tree(rest)
        tree.children = [rest_of_tree]
    if tree_or_children_is_next(rest):
        children = split_up_children(rest)
        children_trees = [parse_tree(child) for child in children]
        tree.children = children_trees
    return tree


def node_is_next(input_string):
    return input_string[0] == ";"

def tree_or_children_is_next(input_string):
    return input_string[0] == '('

def parse_root_node(input_string):

    tree = SgfTree()
    properties = r.findall(r"[A-Z]+(?:\[.*?(?<!\\)\])+", input_string, flags=r.DOTALL)

    if len(properties) == 0 and len(input_string) > 0:
        raise ValueError("Failed to parse property.")
    for prop in properties:
        m = r.fullmatch(r"(?<Key>[A-Z]+)(?<valueList>(?:\[.+?(?<!\\)\])+)", prop, flags=r.DOTALL)
        key = m.group("Key")
        value_list = m.group("valueList")
        value_list = parse_value_list(value_list)
        tree.properties[key] = value_list

    return tree


def parse_value_list(input_string):
    values = r.findall(r"\[(?<value>.*?)(?<!\\)\]", input_string, flags=r.DOTALL)
    return [clean_value(value) for value in values]

def split_up_children(input_string):
    children = r.findall(r"(?:\(([^()]*)\))", input_string, flags=r.DOTALL)

    return children


def clean_value(input_string):
    input_string = r.sub(r"\t", " ", input_string, flags=r.DOTALL)
    input_string = r.sub(r"\\(?=\\)|\\(?=\])", "", input_string, flags=r.DOTALL)
    return input_string
