import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;
    static final int MAX = 191230;
    static int[] dp = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sb.append(dp[N]).append("\n");

        }
        System.out.print(sb.toString());
        sc.close();
    }
}