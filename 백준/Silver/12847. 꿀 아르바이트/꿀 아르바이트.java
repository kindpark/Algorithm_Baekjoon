import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < m){
                answer += arr[i];
            }
        }

        long temp = answer;
        for (int i = m; i < n; i++) {
            temp += arr[i] - arr[i - m];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}