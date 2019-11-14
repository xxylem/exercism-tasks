using System.Collections.Generic;

public static class Pangram
{
    public static bool IsPangram(string input)
    {
        HashSet<char> lettersFound = new HashSet<char>();

        foreach (char c in input)
            if (char.IsLetter(c))
                lettersFound.Add(char.ToLower(c));

        return lettersFound.Count == 26;
    }
}
