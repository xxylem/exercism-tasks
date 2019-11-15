using System;

public enum Schedule
{
    Teenth,
    First,
    Second,
    Third,
    Fourth,
    Last
}


public class Meetup
{
    private readonly DateTime StartOfMonth;
    public Meetup(int month, int year) => StartOfMonth = new DateTime(year, month, 1);

    private DateTime First(DayOfWeek dayOfWeek)
    {
        var result = StartOfMonth;
        while (result.DayOfWeek != dayOfWeek)
            result = result.AddDays(1);
        return result;
    }

    private DateTime Second(DayOfWeek dayOfWeek) => First(dayOfWeek).AddDays(7);
    private DateTime Third(DayOfWeek dayOfWeek) => First(dayOfWeek).AddDays(14);
    private DateTime Fourth(DayOfWeek dayOfWeek) => First(dayOfWeek).AddDays(21);

    private DateTime Last(DayOfWeek dayOfWeek)
    {
        var result = StartOfMonth.AddMonths(1).AddDays(-1);
        while (result.DayOfWeek != dayOfWeek)
            result = result.AddDays(-1);
        return result;
    }

    private DateTime Teenth(DayOfWeek dayOfWeek)
    {
        var result = StartOfMonth.AddDays(12);
        while (result.DayOfWeek != dayOfWeek)
            result = result.AddDays(1);
        return result;
    }

    public DateTime Day(DayOfWeek dayOfWeek, Schedule schedule)
    {
        switch (schedule)
        {
            case Schedule.First:
                return First(dayOfWeek);

            case Schedule.Second:
                return Second(dayOfWeek);

            case Schedule.Third:
                return Third(dayOfWeek);

            case Schedule.Fourth:
                return Fourth(dayOfWeek);

            case Schedule.Last:
                return Last(dayOfWeek);

            case Schedule.Teenth:
                return Teenth(dayOfWeek);

            default:
                throw new System.ArgumentOutOfRangeException("Bad schedule.");
        }
    }
}