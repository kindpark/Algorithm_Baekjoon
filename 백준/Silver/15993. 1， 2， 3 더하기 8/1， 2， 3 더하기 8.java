import java.util.*;
import java.io.*;

public class Main {
    static int mod = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long[] coin1 = new long[100001];
        long[] coin2 = new long[100001];
        //2는 짝수이기에 없음
        coin2[1] = 1;
        coin1[2] = 1;
        coin2[2] = 1;
        coin1[3] = 2;
        coin2[3] = 2;
        for(int i = 4; i < 100001; i++){
            coin1[i] = (coin2[i-1] + coin2[i-2] + coin2[i-3])%mod;
            coin2[i] = (coin1[i-1] + coin1[i-2] + coin1[i-3])%mod;
        }
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            bw.write(coin2[n]%mod + " " + coin1[n]%mod +'\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
