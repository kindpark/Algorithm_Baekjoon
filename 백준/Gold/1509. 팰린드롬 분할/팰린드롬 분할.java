import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        s = " " + s; // 문자열의 인덱스를 1부터 시작하게 하기 위해서
        boolean[][] b = new boolean[2503][2503];
        int[] dp = new int[2503];

        for (int i = 1; i <= n; i++) b[i][i] = true;
        for (int i = 1; i < n; i++) b[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        for (int j = 2; j < n; j++) {
            for (int i = 1; i + j <= n; i++) {
                if (s.charAt(i) == s.charAt(i + j) && b[i + 1][i + j - 1]) b[i][i + j] = true;
            }
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (b[j][i]) dp[i] = Math.min(dp[i], dp[j - 1] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
