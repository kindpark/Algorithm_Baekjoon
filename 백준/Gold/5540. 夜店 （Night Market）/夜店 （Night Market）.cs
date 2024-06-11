using System;

public class Program
{
    const int maxn = 3007;
    static int n, t, s;
    static int[,] dp = new int[maxn, maxn];
    static int[] A = new int[maxn];
    static int[] B = new int[maxn];

    public static void Main()
    {
        string[] input = Console.ReadLine().Split();
        n = int.Parse(input[0]);
        t = int.Parse(input[1]);
        s = int.Parse(input[2]);

        for(int i = 1; i <= n; i++)
        {
            input = Console.ReadLine().Split();
            A[i] = int.Parse(input[0]);
            B[i] = int.Parse(input[1]);
        }

        Array.Clear(dp, 0, dp.Length);

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= t; j++)
            {
                dp[i, j] = dp[i - 1, j];
                dp[i, j] = Math.Max(dp[i, j], dp[i, j - 1]);

                if(j >= B[i] && !(j - B[i] < s && j > s))
                {
                    dp[i, j] = Math.Max(dp[i, j], dp[i - 1, j - B[i]] + A[i]);
                }
            }
        }

        Console.WriteLine(dp[n, t]);
    }
}
