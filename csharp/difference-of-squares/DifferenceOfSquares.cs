using System;

public static class DifferenceOfSquares
{
    public static int CalculateSquareOfSum(int n)
    {
        int sum = (n * (n + 1)) / 2;
        return sum * sum;
    }
    public static int CalculateSumOfSquares(int n) => ((2 * n + 1) * n * (n + 1)) / 6;

    public static int CalculateDifferenceOfSquares(int n) => CalculateSquareOfSum(n) - CalculateSumOfSquares(n);
}