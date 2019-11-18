using System.Collections.Generic;
using System.Linq;

public class HighScores
{
    private readonly List<int> ScoreList;

    public HighScores(List<int> list) => ScoreList = list;

    public List<int> Scores() =>
        // Since the usage of this API is unknown, returns a copy 
        // to prevent external changes to internal state.
        ScoreList.ToList();

    public int Latest() => ScoreList.Last();

    public int PersonalBest() => ScoreList.Max();

    public List<int> PersonalTopThree() 
        => ScoreList.OrderByDescending(v => v)
                    .Take(3)
                    .ToList();
}