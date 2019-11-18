using System;
using System.Linq;
using System.Text.RegularExpressions;

public static class LargestSeriesProduct
{
    private static long GetLargestProductOfSubGroupNoZeros(string digits, int span)
    {
        long max_product = 0;
        for (int i = 0; i <= digits.Length - span; i++)
        {
            max_product = Math.Max(max_product,
                digits.Substring(i, span).Select(c => (long)char.GetNumericValue(c)).Aggregate(1L, (prod, next) => prod * next));
        }
        return max_product;
    }

    public static long GetLargestProduct(string digits, int span) 
    {
        if (span < 0)
            throw new ArgumentException("Span must be non-negative.");

        if (span > digits.Length)
            throw new ArgumentException("Span cannot be larger than the number of digits.");

        if (Regex.IsMatch(digits, "[^0-9]"))
            throw new ArgumentException("Input string can only contain digits.");

        long max_product = 0;
        string[] digits_subgroups = digits.Split('0');
        foreach (string digits_subgroup in digits_subgroups)
        {
            max_product = Math.Max(max_product, GetLargestProductOfSubGroupNoZeros(digits_subgroup, span));
        }

        return max_product;
    }
}