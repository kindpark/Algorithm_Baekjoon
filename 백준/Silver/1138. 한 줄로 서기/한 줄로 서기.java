import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] init = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            init[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            int j =  0;
            while(true) {
                if (res[j] == 0 && init[i] == 0) {
                    res[j] = i+1;
                    break;
                }
                else if(res[j] == 0){
                    init[i]--;
                }
                j++;
            }
        }
        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(res[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

