import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[][] dp = new long[m + 1][n + 1];
        dp[0][0] = 1;
        //i번 숫자까지 고려하여 총 j개를 만드는 경우의 수 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //i번 숫자를 x개 사용하는 경우 (0 <= x <= k)
                //이부분 몰라서 참고 했습니다.
                for (int x = 0; x <= k && j + x <= n; x++) {
                    dp[i][j + x] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}