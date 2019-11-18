using System;
using System.Collections.Generic;

public static class PythagoreanTriplet
{
    public static IEnumerable<(int a, int b, int c)> TripletsWithSum(int sum)
    {
        // a + b + c == sum
        // by the triangle inequality: b + c >= a,
        // if a == sum / 2, then b + c == sum / 2 == a
        // ==> a is at most sum / 2.
        int end = sum / 2;
        for (int a = 1; a <= end; a++)
        {
            var triplet = TripletWithFixedSideA(a, sum);
            if (triplet.HasValue)
                yield return triplet.Value;
        }
            
    }

    private static (int a, int b, int c)? TripletWithFixedSideA(int a, int sum)
    {
        // This algorithm works by divide and conquer on the range of possible values of side b.
        int b_min = a + 1;
        int b_max = sum - 1;
        
        while (b_min < b_max)
        {
            int b = (b_min + b_max) / 2;
            double c = Math.Sqrt(a * a + b * b);
            double sum_of_sides = a + b + c;

            if (NearlyEqual(sum_of_sides, sum))
                // c is implicitly an integer or the sums would not be nearly equal.
                return (a, b, (int)(c + 0.5));

            // There is no pythagorean triplet for this value of a.
            if (b_min == b_max)
                return null;

            // Needed to avoid getting stuck when calculating the new value for b
            if (b_max - b_min == 1)
            {
                b_min++;
                continue;
            }

            if (sum_of_sides > sum)
                b_max = b;
            else
                b_min = b;

        }
        return null;
    }

    private static bool NearlyEqual(double doubleValue, int integerValue) 
        => Math.Abs(doubleValue - integerValue) < 0.0001;

}