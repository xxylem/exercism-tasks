inequality(X, Y, Z) :- Y + Z >= X,
                        X + Z >= Y,
                        X + Y >= Z.

positive(X, Y, Z) :- X > 0, Y > 0, Z > 0.
triangle(X, Y, Z) :- positive(X, Y, Z),
                        inequality(X, Y, Z).

triangle(X, X, X, "equilateral") :- triangle(X, X, X),
                                        !.

triangle(X, Y, Z, "isosceles") :- (X =:= Y; X =:= Z; Y =:= Z),
                                    triangle(X, Y, Z),
                                    !.

triangle(X, Y, Z, "scalene") :- X \= Y, Y \= Z, X \= Z,
                                    triangle(X, Y, Z).