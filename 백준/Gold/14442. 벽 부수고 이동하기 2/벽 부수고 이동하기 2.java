import java.util.*;
import java.io.*;

public class Main {
    static int mod = 1000000009;
    static int n, m, k, ans=-1;
    static int[][] map;
    static boolean[][][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check= new boolean[n][m][k+1];
        String s;
        for(int i = 0; i < n; i++){
            s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        bfs();
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        check[0][0][0] = true;
        while(!q.isEmpty()){
            Node nd = q.poll();
            if(nd.x == n-1 && nd.y == m-1){
                ans = nd.dist;
                break;
            }
            for(int i = 0; i < 4; i++){
                int mx = dx[i] + nd.x;
                int my = dy[i] + nd.y;
                if(mx < 0 || my < 0 || mx >= n || my >= m) continue;
                //안 막혔을 경우
                if(map[mx][my] == 0 && !check[mx][my][nd.bc]){
                    check[mx][my][nd.bc] = true;
                    q.add(new Node(mx, my, nd.dist+1, nd.bc));
                }
                //막힘
                else{
                    //뚫을수 있을때
                    if(nd.bc < k && !check[mx][my][nd.bc+1]){
                        check[mx][my][nd.bc+1] = true;
                        q.add(new Node(mx, my, nd.dist+1, nd.bc+1));
                    }
                }
            }
        }
    }
    public static class Node{
        int x, y, dist, bc;
        Node(int x, int y, int dist, int bc){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.bc = bc;
        }
    }
}
