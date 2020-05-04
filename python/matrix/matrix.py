class Matrix:
    def __init__(self, matrix_string):
        # Store matrix as 2d integer row-major array
        self.__matrix = [list(map(int, row.split(" "))) for row in matrix_string.split("\n")]

    def row(self, index):
        return self.__matrix[index - 1]

    def column(self, index):
        return list(map(lambda row: row[index - 1], self.__matrix))
