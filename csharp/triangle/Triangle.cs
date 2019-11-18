using System;

public static class Triangle
{
    private static double ComputeTolerance(double side1)
        => Math.Abs(side1 * .00001);

    private static bool NearlyEqual(double side1, double side2) 
        => Math.Abs(side2 - side1) <= ComputeTolerance(side1);

    private static bool AllSidesHavePositiveLength(double side1, double side2, double side3) 
        => side1 > 0 && side2 > 0 && side3 > 0;

    private static bool SatisfiesTriangleInequality(double side1, double side2, double side3) 
        =>     side1 + side2 >= side3
            && side1 + side3 >= side2
            && side2 + side3 >= side1;


    public static bool IsScalene(double side1, double side2, double side3) 
        =>     AllSidesHavePositiveLength(side1, side2, side3)
            && SatisfiesTriangleInequality(side1, side2, side3)
            && !(NearlyEqual(side1, side2) || NearlyEqual(side1, side3) || NearlyEqual(side2, side3));

    public static bool IsIsosceles(double side1, double side2, double side3) 
        =>     AllSidesHavePositiveLength(side1, side2, side3)
            && SatisfiesTriangleInequality(side1, side2, side3)
            && (NearlyEqual(side1, side2) || NearlyEqual(side1, side3) || NearlyEqual(side2, side3));

    public static bool IsEquilateral(double side1, double side2, double side3) 
        =>     AllSidesHavePositiveLength(side1, side2, side3)
            && NearlyEqual(side1, side2)
            && NearlyEqual(side2, side3);
}