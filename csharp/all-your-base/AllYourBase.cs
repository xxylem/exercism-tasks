using System.Collections.Generic;

public static class AllYourBase
{
    private static int ToDecimal(int inputBase, int[] inputDigits)
    {
        int result = 0;
        int multiplicand = 1;
        for (int i = inputDigits.Length - 1; i >=0; i--)
        {
            int digit = inputDigits[i];
            if (digit < 0)
                throw new System.ArgumentException($"Digit must be non-negative: given {digit} at array index {i}.");
            if (digit >= inputBase)
                throw new System.ArgumentException(
                    $"Digit must be smaller than inputBase: given {digit} at array index {i} with input base {inputBase}.");

            result += digit * multiplicand;
            multiplicand *= inputBase;
        }
        return result;
    }

    private static int[] FromDecimal(int decimalNumber, int outputBase)
    {
        var digits = new List<int>();
        do
        {
            digits.Add(decimalNumber % outputBase);
            decimalNumber /= outputBase;
        } while (decimalNumber > 0);
        digits.Reverse();
        return digits.ToArray();
    }

    public static int[] Rebase(int inputBase, int[] inputDigits, int outputBase)
    {
        if (inputBase < 2)
            throw new System.ArgumentException($"Input base must be 2 or greater: given {inputBase}.");

        if (outputBase < 2)
            throw new System.ArgumentException($"Output base must be 2 or greater: given {outputBase}.");

        return FromDecimal(ToDecimal(inputBase, inputDigits), outputBase);
    }
}