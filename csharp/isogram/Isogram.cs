using System.Collections.Generic;

public static class Isogram
{
    public static bool IsIsogram(string word)
    {
        var lettersSeen = new HashSet<char>();

        foreach (char c in word)
            if (char.IsLetter(c))
            {
                char c_lower = char.ToLower(c);
                if (lettersSeen.Contains(c_lower))
                    return false;
                else
                    lettersSeen.Add(c_lower);
            }

        return true;
    }
}
