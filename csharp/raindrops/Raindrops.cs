using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

public static class Raindrops
{
    private static readonly ReadOnlyDictionary<int, string> DROPS = new ReadOnlyDictionary<int, string>
        (
            new Dictionary<int, string>()
            {
                { 3, "Pling" },
                { 5, "Plang" },
                { 7, "Plong" }
            }
        );

    public static string Convert(int number)
    { 
        var sb = new StringBuilder();
        foreach (var drop in DROPS)
        {
            if (number % drop.Key == 0)
                sb.Append(drop.Value);
        }
        
        return sb.Length > 0 ? sb.ToString() : number.ToString();
    }
}