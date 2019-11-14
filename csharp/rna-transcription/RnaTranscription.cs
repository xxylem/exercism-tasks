using System.Collections.Generic;
using System.Linq;

public static class RnaTranscription
{

    private static readonly Dictionary<char, char> nucleotideMap = new Dictionary<char, char>()
    {
        { 'G', 'C' },
        { 'C', 'G' },
        { 'T', 'A' },
        { 'A', 'U' }
    };

    public static string ToRna(string dna_strand)
    {
        return string.Concat(dna_strand.Select(c => nucleotideMap[c]));
    }
}