from math import hypot, sin, cos, exp as math_exp


class ComplexNumber(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __eq__(self, other):
        return self.real == other.real and self.imaginary == other.imaginary

    def __add__(self, other):
        return ComplexNumber(
            self.real + other.real,
            self.imaginary + other.imaginary)

    def __mul__(self, other):
        return ComplexNumber(
            self.real * other.real - self.imaginary * other.imaginary,
            self.imaginary * other.real + self.real * other.imaginary)

    def __sub__(self, other):
        return ComplexNumber(
            self.real - other.real,
            self.imaginary - other.imaginary)

    def __truediv__(self, other):
        denom = other.real ** 2 + other.imaginary ** 2
        return ComplexNumber(
            (self.real * other.real + self.imaginary * other.imaginary) / denom,
            (self.imaginary * other.real - self.real * other.imaginary) / denom)

    def __abs__(self):
        return hypot(self.real, self.imaginary)

    def conjugate(self):
        return ComplexNumber(
            self.real,
            -self.imaginary)

    def exp(self):
        ea = math_exp(self.real)
        return ComplexNumber(
            ea * cos(self.imaginary),
            ea * sin(self.imaginary))
