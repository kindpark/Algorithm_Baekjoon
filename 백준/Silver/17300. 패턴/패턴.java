import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq= new LinkedList<>();
        StringTokenizer st;
        int[][] pat = {{1,2,3},{4,5,6},{7,8,9}};
        int n = Integer.parseInt(br.readLine());
        int[] query = new int[n];
        boolean[] visit = new boolean[10];
        String ans = "";
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            query[i] = Integer.parseInt(st.nextToken());
        }
        int prev = 0, cur = 0;
        for(int i = 0; i < n; i++){
            prev = cur;
            cur = query[i];
            if(visit[query[i]]){
                bw.write("NO\n");
                bw.flush();
                System.exit(0);
            }
            visit[query[i]] =true;
            if(prev == 0){
                continue;
            }
            if(!visit[2]){
                if(prev + cur == 4){
                    bw.write("NO");
                    bw.flush();
                    System.exit(0);
                }
            }
            if(!visit[4]){
                if(prev == 1 && cur == 7 || prev == 7 && cur == 1){
                    bw.write("NO");
                    bw.flush();
                    System.exit(0);
                }
            }
            if(!visit[5]){
                if(prev + cur == 10){
                    bw.write("NO");
                    bw.flush();
                    System.exit(0);
                }
            }
            if(!visit[6]){
                if(prev == 3 && cur == 9 || prev == 9 && cur == 3){
                    bw.write("NO");
                    bw.flush();
                    System.exit(0);
                }
            }
            if(!visit[8]){
                if(prev + cur == 16){
                    bw.write("NO");
                    bw.flush();
                    System.exit(0);
                }
            }
        }
        bw.write("YES");
        bw.flush();
        br.close();
        bw.close();
    }
}
