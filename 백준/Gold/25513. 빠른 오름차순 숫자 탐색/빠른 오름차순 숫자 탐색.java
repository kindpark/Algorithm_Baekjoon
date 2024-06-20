import java.util.*;
import java.io.*;
public class Main {
    static int x, y;
    static int[][] board;
    static boolean[][][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        board = new int[5][5];
        check = new boolean[5][5][7];
        StringTokenizer st;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(bfs(y, x)));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x, 0, 0));
        check[x][y][0] = true;
        while(!q.isEmpty()){
            Node nd = q.poll();
            if(nd.idx == 6){
                return nd.cnt;
            }
            int idx = nd.idx;
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + nd.x;
                int ny = dy[i] + nd.y;
                if(ny < 0 || nx < 0 || 5 <= ny || 5 <= nx || board[ny][nx] == -1) continue;
                if(check[nx][ny][idx]) continue;
                check[nx][ny][idx] = true;
                int aidx = idx;
                if(board[ny][nx] == idx+1) aidx++;
                q.add(new Node(ny, nx, aidx, nd.cnt+1));
            }
        }
        return -1;
    }
    static class Node{
        int x;
        int y;
        int idx;
        int cnt;
        Node(int y, int x, int idx, int cnt){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}