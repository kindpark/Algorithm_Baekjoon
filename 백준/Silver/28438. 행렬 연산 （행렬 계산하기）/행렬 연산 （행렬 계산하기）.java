import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] row = new int[n];
        int[] col = new int[m];
        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(query == 1){
                row[r-1] += v;
            }
            else{
                col[r-1] += v;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(row[i] + col[j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}