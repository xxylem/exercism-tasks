using System;

public static class Gigasecond
{
    private static readonly int GIGASECOND = 1000000000;

    public static DateTime Add(DateTime moment) => moment.AddSeconds(GIGASECOND);
}