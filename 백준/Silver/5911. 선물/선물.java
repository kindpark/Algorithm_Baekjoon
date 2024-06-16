import java.io.*;
import java.util.*;

public class Main {
    static int[] P;
    static int[] S;
    static int n, b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        P = new int[n];
        S = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < n - 1; i++) {
                if (P[i] + S[i] > P[i + 1] + S[i + 1]) {
                    int tmp = P[i]; P[i] = P[i + 1]; P[i + 1] = tmp;
                    tmp = S[i]; S[i] = S[i + 1]; S[i + 1] = tmp;
                    done = false;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(select(i) > res){
                res = select(i);
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int select(int a){
        int bg = b - (P[a]/2 + S[a]);
        int t = 1;
        if(bg < 0)
            return 0;
        for(int j = 0; j < n; j++){
            if(P[j] + S[j] <= bg && j != a){
                bg -= (P[j] + S[j]);
                t++;
            }

        }
        return t;
    }

}
