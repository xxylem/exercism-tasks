from __future__ import division
from math import gcd


class Rational(object):
    def __init__(self, numer, denom):

        gcd_ = gcd(int(numer), int(denom))
        
        self.numer = numer / gcd_
        self.denom = denom / gcd_

        if self.numer < 0 and self.denom < 0:
            self.numer = abs(self.numer)
            self.denom = abs(self.denom)
        elif self.denom < 0:
            self.numer = -self.numer
            self.denom = -self.denom

    def __eq__(self, other):
        return self.numer == other.numer and self.denom == other.denom

    def __repr__(self):
        return '{}/{}'.format(self.numer, self.denom)

    def __add__(self, other):
        return Rational(
            self.numer * other.denom + self.denom * other.numer,
            self.denom * other.denom)

    def __sub__(self, other):
        return Rational(
            self.numer * other.denom - self.denom * other.numer,
            self.denom * other.denom)

    def __mul__(self, other):
        return Rational(
            self.numer * other.numer,
            self.denom * other.denom)

    def __truediv__(self, other):
        return self * other.reciprocal()

    def __abs__(self):
        return Rational(
            abs(self.numer),
            abs(self.denom))

    def __pow__(self, power):
        return Rational(
            self.numer ** power,
            self.denom ** power)

    def __rpow__(self, base):
        return base ** (self.numer / self.denom)

    def reciprocal(self):
        return Rational(self.denom, self.numer)