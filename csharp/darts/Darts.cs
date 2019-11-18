using System;

public static class Darts
{
    public static int Score(double x, double y)
    {
        double dist = Math.Sqrt(x * x + y * y);

        return dist > 10 ? 0 
             : dist > 5  ? 1 
             : dist > 1  ? 5 
             :             10;
    }
}
