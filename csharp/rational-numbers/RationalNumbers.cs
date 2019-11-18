using System;

public static class RealNumberExtension
{
    public static double Expreal(this int realNumber, RationalNumber r) 
        => Math.Pow(realNumber, r.ToReal());
}

public struct RationalNumber
{
    private readonly int Numerator;
    private readonly int Denominator;

    public RationalNumber(int numerator, int denominator)
    {
        if (denominator == 0)
            throw new DivideByZeroException("Denominator cannot be zero.");

        if (denominator < 0)
        {
            numerator = -numerator;
            denominator = -denominator;
        }
               
        int gcd = GCD(Math.Abs(numerator), Math.Abs(denominator));
        Numerator = numerator / gcd;
        Denominator = denominator / gcd;
    }

    private static int GCD(int a, int b)
    {
        while (a != 0 && b != 0)
        {
            if (a > b)
                a %= b;
            else
                b %= a;
        }

        return a == 0 ? b : a;
    }

    public static RationalNumber operator +(RationalNumber r1, RationalNumber r2) 
        => new RationalNumber(
            r1.Numerator * r2.Denominator + r1.Denominator * r2.Numerator,
            r1.Denominator * r2.Denominator);

    public static RationalNumber operator -(RationalNumber r1, RationalNumber r2) 
        => new RationalNumber(
            r1.Numerator * r2.Denominator - r2.Numerator * r1.Denominator,
            r1.Denominator * r2.Denominator);

    public static RationalNumber operator *(RationalNumber r1, RationalNumber r2) 
        => new RationalNumber(
            r1.Numerator * r2.Numerator,
            r1.Denominator * r2.Denominator);

    public static RationalNumber operator /(RationalNumber r1, RationalNumber r2) 
        => new RationalNumber(
            r1.Numerator * r2.Denominator,
            r2.Numerator * r1.Denominator);

    public RationalNumber Abs() 
        => new RationalNumber(
            Math.Abs(Numerator),
            Math.Abs(Denominator));

    // Kept for compatibility with test suite. All RationalNumbers are stored in reduced form.
    public RationalNumber Reduce() => this;

    public RationalNumber Exprational(int power) 
        => new RationalNumber(
            (int)Math.Pow(Numerator, power),
            (int)Math.Pow(Denominator, power));

    public double ToReal() => Numerator / (double)Denominator;

    public double Expreal(int baseNumber) => Math.Pow(baseNumber, ToReal());
}