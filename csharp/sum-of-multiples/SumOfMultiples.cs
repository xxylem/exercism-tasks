using System.Collections.Generic;
using System.Linq;

public static class SumOfMultiples
{
    public static int Sum(IEnumerable<int> factors, int max)
    {
        var multiples = new HashSet<int>();
        foreach (int factor in factors)
        {
            if (factor == 0)
                continue;

            for (int i = factor; i < max; i += factor)
                multiples.Add(i);
        }

        return multiples.Sum();

    }
}