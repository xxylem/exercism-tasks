using System;
using System.Collections.Generic;
using System.Text;

public class Robot
{
    private static readonly Random random = new Random();
    private static readonly HashSet<string> NamesInUse = new HashSet<string>();

    public Robot() => Reset();

    public string Name { get; private set; }

    public void Reset()
    {
        string new_name;
        do
        {
            var sb = new StringBuilder();

            sb.Append(RandomUppercaseLetter());
            sb.Append(RandomUppercaseLetter());

            sb.Append(RandomThreeDigitNumber());

            new_name = sb.ToString();

        } while (NamesInUse.Contains(new_name));

        NamesInUse.Remove(Name);
        Name = new_name;
        NamesInUse.Add(Name);
    }

    private static char RandomUppercaseLetter() => (char)random.Next('A', 'Z');
    private static string RandomThreeDigitNumber() => random.Next(0, 999).ToString().PadLeft(3, '0');
}