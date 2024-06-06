import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] time = new int[m+1];
        int[] important = new int[m+1];
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            important[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j<= n; j++){
                if(time[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+important[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[m][n]));
        bw.flush();
        bw.close();
        br.close();
    }
}