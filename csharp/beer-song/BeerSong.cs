using System.Collections.Generic;
using System.Text;

public static class BeerSong
{

    public static string Recite(int startBottles, int takeDown)
    {
        var verses = new List<StringBuilder>();
        for (int number_of_bottles = startBottles; 
            takeDown > 0 && number_of_bottles >= 0; 
            number_of_bottles--, takeDown--)
        {
            verses.Add(Verse(number_of_bottles));
        }

        return string.Join("\n\n", verses);
    }

    private static StringBuilder Verse(int number_of_bottles) 
        => FirstLine(number_of_bottles)
                .Append(SecondLine(number_of_bottles));

    private static StringBuilder FirstLine(int number_of_bottles)
    {
        var line = new StringBuilder();

        line.Append($"{(number_of_bottles > 0 ? number_of_bottles.ToString() : "No more")} " +
                $"{BottleOrBottles(number_of_bottles)}");
        line.Append(" of beer on the wall, ");

        line.Append($"{(number_of_bottles > 0 ? number_of_bottles.ToString() : "no more")} " +
            $"{BottleOrBottles(number_of_bottles)}");
        line.Append(" of beer.\n");

        return line;
    }

    private static StringBuilder SecondLine(int number_of_bottles)
    {
        var line = new StringBuilder();

        if (number_of_bottles == 0)
            line.Append("Go to the store and buy some more, 99 bottles of beer on the wall.");
        else
        {
            line.Append($"Take {(number_of_bottles == 1 ? "it" : "one")} down and pass it around, ");
            line.Append($"{(number_of_bottles - 1 > 0 ? (number_of_bottles - 1).ToString() : "no more")} " +
                $"{BottleOrBottles(number_of_bottles - 1)}");
            line.Append(" of beer on the wall.");
        }

        return line;
    }

    private static StringBuilder BottleOrBottles(int number_of_bottles) 
        => new StringBuilder(number_of_bottles == 1 ? "bottle" : "bottles");
}