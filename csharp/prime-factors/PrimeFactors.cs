using System.Collections.Generic;

public static class PrimeFactors
{
    public static long[] Factors(long number)
    {
        var factors = new List<long>();
        for (long factor = 2; factor <= number; factor++)
        {
            while (number % factor == 0)
            {
                factors.Add(factor);
                number /= factor;
            }
        }
        return factors.ToArray();
    }
}