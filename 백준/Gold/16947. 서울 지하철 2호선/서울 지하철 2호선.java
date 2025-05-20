import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] station;
    static boolean[] square;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        station = new ArrayList[n+1];
        for(int i = 0; i <=n; i++){
            station[i] = new ArrayList<>();
        }
        square = new boolean[n+1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            station[a].add(b);
            station[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            if(dfs(i, i, i)) {
                break;
            }
            square = new boolean[n+1];
        }
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++) {
            if (!square[i]) res[i] = bfs(i);
        }
        for(int i = 1; i <= n; i++){
            System.out.print(res[i] + " ");
        }
    }
    public static int bfs(int node){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new Node(node, 0));
        visited[node] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(square[cur.n]) return cur.cnt;
            for(int i = 0; i < station[cur.n].size(); i++){
                int next = station[cur.n].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next, cur.cnt+1));
                }
            }
        }
        return 0;
    }
    public static boolean dfs(int prev, int t, int start){
        square[t] = true;
        for(int i = 0; i < station[t].size(); i++){
            int next = station[t].get(i);
            if(!square[next]){

                if(dfs(t, next, start)) return true;
            }

            else if(next != prev && next == start) return true;
        }
        square[t] = false;
        return false;
    }
    static class Node{
        int n;
        int cnt;
        Node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
}
