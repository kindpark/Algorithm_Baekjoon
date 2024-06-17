import java.io.*;
import java.util.*;

public class Main {
    static int[] P;
    static int[] S;
    static int n, m, q;
    static ArrayList<P> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        boolean[][] ans = new boolean[m+1][n+1];
        int[] sol = new int[n+1];
        int[][] wa = new int[n+1][m+1];
        int[] time = new int[n+1];
        list = new ArrayList<>();
        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int team = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            String r = st.nextToken();
            if(!ans[num][team]){
                wa[team][num]++;
                if(r.equals("AC")){
                    time[team] += ((wa[team][num]-1) * 20 + ti);
                    ans[num][team] = true;
                    sol[team]++;
                }
            }
            else {
                continue;
            }
        }
        for(int i = 1; i <= n; i++){
            list.add(new P(i, sol[i], time[i]));
            //System.out.println(i + " " + sol[i] + " " + time[i]);
        }

        Collections.sort(list, (P p1, P p2) -> {
            if(p1.sol == p2.sol){
                return p1.time - p2.time;
            }
            else if(p1.sol > p2.sol){
                return -1;
            }
            return 1;
        });
        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(list.get(i).tn) + " " + String.valueOf(list.get(i).sol) + " " + String.valueOf(list.get(i).time)+'\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static class P{
        int tn;
        int sol;
        int time;
        P(int tn, int sol, int time){
            this.tn = tn;
            this.sol = sol;
            this.time = time;
        }
    }
}
