import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static int[] arr, money;

    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            money = new int[n+1];
            for(int i = 1; i <= n; i++){
                money[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            arr = new int[m+1];
            arr[0] = 1;
            for(int i = 1; i <= n; i++){
                for(int j = money[i]; j <= m; j++){
                    arr[j] = arr[j] + arr[j-money[i]];
                }
            }
            bw.write(String.valueOf(arr[m])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
