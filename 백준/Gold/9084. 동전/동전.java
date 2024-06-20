import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] dp, mn;
        
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            mn = new int[n+1];
            for(int i = 1; i <= n; i++){
                mn[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            dp = new int[m+1];
            dp[0] = 1;
            for(int i = 1; i <= n; i++){
                for(int j = mn[i]; j <= m; j++){
                    dp[j] = dp[j] + dp[j-mn[i]];
                }
            }
            bw.write(String.valueOf(dp[m]+"\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}