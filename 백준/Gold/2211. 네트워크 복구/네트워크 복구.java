import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Edge>[] list;
    static int[] distance;
    static int[] con;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        distance = new int[n+1];
        con = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        Arrays.fill(distance, 1000000000);
        int cnt = 0;
        djikstra();
        for(int i = 2; i <= n; i++){
            cnt++;
            sb.append(i + " " + String.valueOf(con[i]) + '\n');
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
        br.close();
    }
    static void djikstra() {
        //1번은 출발지점
        distance[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(edge.connect > distance[edge.b]){
                continue;
            }
            for(Edge e: list[edge.b]){
                if(distance[e.b] > e.connect + distance[edge.b]){
                    distance[e.b] = e.connect + distance[edge.b];
                    con[e.b] = edge.b;
                    pq.add(new Edge(e.b, distance[e.b]));
                }
            }
        }
    }
    public static class Edge implements Comparable<Edge>{
        int b;
        int connect;
        Edge(int b, int connect){
            this.b = b;
            this.connect = connect;
        }
        @Override
        public int compareTo(Edge o) {
            return this.connect<=o.connect ? -1:1;
        }
    }
}