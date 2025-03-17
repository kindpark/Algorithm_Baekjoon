import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] val = new int[n];
        int[] weight = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            val[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        int inf = Integer.MAX_VALUE;
        int[][] dp = new int[v+1][w+1];
        for(int i=0; i <= v; i++){
            Arrays.fill(dp[i], inf);
        }
        dp[0][0] = 0;
            for(int j = 0; j <= v; j++){
                for(int k = 0; k <= w; k++){
                    if(dp[j][k] != inf){
                        for(int i = 0; i < n; i++) {
                            int nv = j + val[i];
                            int nw = k + weight[i];
                            if (nv <= v && nw <= w) {
                                dp[nv][nw] = Math.min(dp[nv][nw], dp[j][k] + 1);
                            }
                        }
                    }
                }
            }

        System.out.println(dp[v][w] == inf ? 0 : dp[v][w]);
        br.close();
    }
}
