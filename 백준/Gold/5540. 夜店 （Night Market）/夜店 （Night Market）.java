import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] tanoshi = new int[n+1];
        int[] jikan = new int[n+1];
        int[][] dp = new int[n+1][t+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            tanoshi[i] = Integer.parseInt(st.nextToken());
            jikan[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= t; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                if(j>=jikan[i] && !(j-jikan[i] < s && j>s)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-jikan[i]]+tanoshi[i]);
                }
            }
        }

        bw.write(String.valueOf(dp[n][t]));
        bw.flush();
        bw.close();
        br.close();

    }
}
