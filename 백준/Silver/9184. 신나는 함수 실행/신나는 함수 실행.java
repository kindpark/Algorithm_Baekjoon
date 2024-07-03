import java.util.*;
import java.io.*;

public class Main {
    static long[][][] ww;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a=0, b=0, c=0;
        ww = new long[51][51][51];
        long ans = 0;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1){
                break;
            }
            bw.write("w(" + a+", " + b + ", " + c + ") = " + String.valueOf(w(a,b,c)) + '\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static long w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        }
        if(ww[a][b][c] >0){
            return ww[a][b][c];
        }
        if(a < b && b < c){
            ww[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
            return ww[a][b][c];
        }
        ww[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        return ww[a][b][c];
    }
}
