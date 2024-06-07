import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] dp;
    static int[] k, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = new int[n+1];
        s = new int[n+1];
        dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            k[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(k[i] > j ){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k[i]]+s[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[n][m]));
        bw.flush();
        bw.close();
        br.close();
    }
}