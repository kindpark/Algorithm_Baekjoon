import java.util.*;
import java.io.*;

public class Main {
    static int n, a, b;
    static int[][] dp;
    static int[] popular, weapons;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            popular = new int[a+1];
            weapons = new int[a+1];
            for(int i = 1; i <= a; i++){
                weapons[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= a; i++){
                popular[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[a+1][b+1];
            for(int i = 1; i <= a; i++){
                for(int j = 1; j <= b; j++){
                    if(weapons[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weapons[i]]+popular[i]);
                    }
                }
            }
            bw.write(String.valueOf(dp[a][b])+'\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
