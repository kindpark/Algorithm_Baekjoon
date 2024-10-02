import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr, map;
    static boolean[][] check;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int t, water=-1, total=0, res;
    static ArrayList<Integer> list;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[t+1][t+1];
        map = new int[t+1][t+1];
        check = new boolean[t+1][t+1];
        list = new ArrayList<>();
        for(int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=t; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > water){
                    water = arr[i][j];
                }
            }
        }
        for(int h = 1; h <= water; h++) {
            for (int i = 1; i <= t; i++) {
                for (int j = 1; j <= t; j++) {
                    if (arr[i][j] < h) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
            for(int i = 1; i <= t; i++){
                for(int j = 1; j<=t; j++){
                    if(map[i][j] == 1 && !check[i][j]) {
                        bfs(i, j);
                        total++;
                    }
                }
            }
            list.add(total);
            reset();
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));

    }
    public static void reset(){
        for(int i = 1; i <= t; i++){
            for(int j = 1; j <= t; j++){
                map[i][j] = 0;
                check[i][j] = false;
            }
        }
        total = 0;
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        check[x][y] = true;
        q.add(new Node(x, y));
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(nx <= 0 || ny <= 0 || nx > t || ny > t) continue;
                if(map[nx][ny]==1 && !check[nx][ny]){
                    check[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}