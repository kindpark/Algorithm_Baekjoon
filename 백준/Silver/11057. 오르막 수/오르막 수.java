import java.util.*;
import java.io.*;
public class Main{
    static final int mod = 10007;
    static int[][] num;
    static int total;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[1001][10];
        for(int i = 0; i <10; i++){
            num[1][i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    num[i][0] = 1;
                    continue;
                }
                num[i][j] = (num[i][j-1] + num[i-1][j])%mod;
            }
        }
        for(int i = 0; i < 10; i++){
            total += num[n][i];
        }
        System.out.println(total%mod);
    }
}