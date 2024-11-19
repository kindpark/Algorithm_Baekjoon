import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int res1 = 0;
        int res2 = 0;
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        a[1] = 1; a[2] = 0; b[1] = 0; b[2] = 1;
        for(int i = 3; i <= n; i++){
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }
        for(int i = 1; i <= m; i++){
            int num = m - (a[n] * i);
            if(num % b[n] == 0){
                System.out.println(i + "\n" + num/b[n]);
                System.exit(0);
            }
        }
    }
}