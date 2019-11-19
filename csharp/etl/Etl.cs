using System.Collections.Generic;

public static class Etl
{
    public static Dictionary<string, int> Transform(Dictionary<int, string[]> old)
    {
        var new_dictionary = new Dictionary<string, int>();
        foreach (var kvp in old)
        {
            foreach (string s in kvp.Value)
            {
                new_dictionary.Add(s.ToLower(), kvp.Key);
            }
        }

        return new_dictionary;
    }
}