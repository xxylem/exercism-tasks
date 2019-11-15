public static class Grains
{
    public static ulong Square(int n)
    {
        if (n < 1 || n > 64)
            throw new System.ArgumentOutOfRangeException($"Only defined on [1,64], given {n}.");

        return 1UL << n - 1;
    }

    public static ulong Total() => 18_446_744_073_709_551_615UL;
}