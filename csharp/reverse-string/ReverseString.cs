using System;

public static class ReverseString
{
    public static string Reverse(string input)
    {
        char[] temp = input.ToCharArray();
        Array.Reverse(temp);
        return new string(temp);
    }
}