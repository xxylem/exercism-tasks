using System.Collections.Generic;
using System.Linq;

public static class PascalsTriangle
{
    public static IEnumerable<IEnumerable<int>> Calculate(int rows)
    {
        int[] lastRow = new int[0];

        for (int rowNumber = 1; rowNumber <= rows; rowNumber++)
        {
            int[] newRow = new int[lastRow.Length + 1];
            newRow[0] = 1;
            newRow[newRow.Length - 1] = 1;
            
            for (int i = 1; i < newRow.Length - 1; i++)
            {
                newRow[i] = lastRow[i - 1] + lastRow[i];
            }

            yield return newRow.AsEnumerable();
            lastRow = newRow;
        }
    }

}