using System;

public static class ArmstrongNumbers
{
    public static bool IsArmstrongNumber(int number)
    {
        int numberOfDigits = number > 0 ? (int) Math.Log10(number) + 1 : 1;
        int sum = 0;
        for (int i = number; i > 0; i /= 10)
            sum += (int) (Math.Pow(i % 10, numberOfDigits) + 0.5);

        return sum == number;
    }
}