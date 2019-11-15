using System.Collections.Generic;

public static class Series
{
    public static string[] Slices(string numbers, int sliceLength)
    {
        if (sliceLength > numbers.Length)
            throw new System.ArgumentException($"sliceLength ({sliceLength}) larger than numbers string.");

        if (sliceLength < 1)
            throw new System.ArgumentException($"sliceLength must be positive: given {sliceLength}");

        var slices = new List<string>();
        int loopEnd = numbers.Length - sliceLength;
        for (int i = 0; i <= loopEnd; i++)
            slices.Add(numbers.Substring(i, sliceLength));

        return slices.ToArray();
    }
}