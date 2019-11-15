public enum Classification
{
    Perfect,
    Abundant,
    Deficient
}

public static class PerfectNumbers
{
    public static Classification Classify(int number)
    {
        if (number < 1)
            throw new System.ArgumentOutOfRangeException($"Only defined on positive integers: given {number}.");

        int sum = 0;
        for (int i = 1; i < number; i++)
        {
            if (number % i == 0)
                sum += i;
        }

        return sum == number ? Classification.Perfect
             : sum > number  ? Classification.Abundant
             :                 Classification.Deficient;
    }
}
