import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- >0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            a = new int[n+1];
            for(int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            dp = new int[m+1];
            dp[0] = 1;
            for(int i = 1; i <= n; i++){
                for(int j = a[i]; j <= m; j++){
                    dp[j] = dp[j] + dp[j-a[i]];
                }
            }
            bw.write(String.valueOf(dp[m])+'\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}