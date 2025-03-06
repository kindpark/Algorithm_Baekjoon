import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Node>> list;
    static int n, m, res = 0;
    static int dist = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, distance));
            list.get(b).add(new Node(a, distance));
        }
        visited = new boolean[n+1];
        for(int w = 0; w < m; w++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(bfs(a, b, n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int bfs(int start, int end, int n){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.next == end)
                return cur.length;
            for(Node next : list.get(cur.next)){
                if(!visited[next.next]){
                    visited[next.next] = true;
                    q.add(new Node(next.next, cur.length + next.length));
                }
            }
        }
        return -1;
    }
    public static class Node{
        int next, length;
        Node(int next, int length){
            this.next = next;
            this.length = length;
        }
    }
}
