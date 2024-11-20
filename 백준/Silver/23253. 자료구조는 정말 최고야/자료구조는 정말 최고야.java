import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean t = true;
        for(int i = 0; i < m; i++){
            int idx = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int standard = Integer.parseInt(st.nextToken());
            for(int j = 0; j < idx-1; j++){
                int comp = Integer.parseInt(st.nextToken());
                if(standard < comp){
                    t = false;
                }
                else{
                    standard = comp;
                }
            }
            if(!t){
                break;
            }
        }
        bw.write(t ? "Yes" : "No");
        bw.flush();
    }
}