using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

public static class ProteinTranslation
{
    private static readonly ReadOnlyDictionary<string, string> Codon_Translations
        = new ReadOnlyDictionary<string, string>
    (
        new Dictionary<string, string>()
        {
            { "AUG", "Methionine" },
            { "UUU", "Phenylalanine" }, { "UUC", "Phenylalanine" },
            { "UUA", "Leucine"}, { "UUG", "Leucine"},
            { "UCU", "Serine"}, { "UCC", "Serine"}, { "UCA", "Serine"}, { "UCG", "Serine"},
            { "UAU", "Tyrosine" },  {"UAC", "Tyrosine" },
            { "UGU", "Cysteine" }, { "UGC", "Cysteine" },
            { "UGG", "Tryptophan" }
        }
    );

    private static bool Is_Stop(string codon) 
        => codon.Equals("UAA") || codon.Equals("UAG") || codon.Equals("UGA");

    public static string[] Proteins(string strand)
    {
        var proteins_found = new List<string>();

        for (int i = 0; i <= strand.Length - 3; i += 3)
        {
            string codon = strand.Substring(i, 3);
            if (Is_Stop(codon))
                return proteins_found.ToArray();

            proteins_found.Add(Codon_Translations[codon]);
        }

        return proteins_found.ToArray();
    }
}