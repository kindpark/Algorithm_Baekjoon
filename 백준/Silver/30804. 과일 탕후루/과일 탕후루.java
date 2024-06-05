import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[] tanhuru, cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int max = 0;
        tanhuru = new int[n];
        st = new StringTokenizer(br.readLine());
        cur = new int[10];
        for(int i = 0; i < n; i++){
            tanhuru[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int index = 0;
        while(right < n){
            cur[tanhuru[right++]]++;
            while(10 - count(cur) > 2){
                cur[tanhuru[left++]]--;
            }
            max = Math.max(max, right-left);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int count(int[] arr){
        int cnt = 0;
        for(int i : arr){
            if(i == 0){
               cnt++;
            }
        }
        return cnt;
    }
}