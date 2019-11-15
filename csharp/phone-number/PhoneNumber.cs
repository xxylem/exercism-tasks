using System.Text.RegularExpressions;

public class PhoneNumber
{
    public static string Clean(string phoneNumber)
    {
        var m = Regex.Match(phoneNumber, @"^(?:\+?1)?\s*\(?(?<area>[2-9]\d\d)\)?[. -]*(?<exchange>[2-9]\d\d)[. -]*(?<subscriber>\d{4})\s*$");

        if (m.Success)
            return $"{m.Groups["area"]}{m.Groups["exchange"]}{m.Groups["subscriber"]}";
        else
            throw new System.ArgumentException($"Bad number: {phoneNumber}");
    }
}