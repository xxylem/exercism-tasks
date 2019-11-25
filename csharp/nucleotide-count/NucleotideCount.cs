using System;
using System.Collections.Generic;

public static class NucleotideCount
{

    public static IDictionary<char, int> Count(string sequence)
    {
        IDictionary<char, int> count = new Dictionary<char, int>
        {
            ['A'] = 0,
            ['C'] = 0,
            ['G'] = 0,
            ['T'] = 0
        };

        foreach (char c in sequence)
        {
            if (count.ContainsKey(c))
            {
                count[c]++;
            }
            else
            {
                throw new ArgumentException($"Invalid nucleotide in sequence: {c}");
            }
        }

        return count;
    }
}