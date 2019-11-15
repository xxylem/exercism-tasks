public static class CollatzConjecture
{
    public static int Steps(int number)
    {
        if (number < 1)
            throw new System.ArgumentException("Only defined on positive integers.");

        // Avoids the argument check on recurive calls.
        int Helper(int n) => 
               n == 1     ? 0
             : n % 2 == 0 ? 1 + Helper(n / 2)
             :              1 + Helper(3 * n + 1);

        return Helper(number);
    }
}