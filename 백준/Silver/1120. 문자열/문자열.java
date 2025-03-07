import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        int res = 51;
        for(int i = 0; i <= (b.length() - a.length()); i++){
            int cnt = 0;
            for(int j = 0; j < a.length(); j++){
                if(a.charAt(j) != b.charAt(j+i)){
                    cnt++;
                }
            }
            res = Math.min(res, cnt);
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}

