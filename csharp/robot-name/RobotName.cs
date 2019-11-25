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
            sb.Append((char) random.Next('A', 'Z'));
            sb.Append((char) random.Next('A', 'Z'));
            sb.Append(random.Next(0, 9));
            sb.Append(random.Next(0, 9));
            sb.Append(random.Next(0, 9));
            new_name = sb.ToString();
        } while (NamesInUse.Contains(new_name));

        NamesInUse.Remove(Name);
        Name = new_name;
        NamesInUse.Add(Name);
    }
}