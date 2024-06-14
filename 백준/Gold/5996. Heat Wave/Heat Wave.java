import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        list = new ArrayList[t+1];
        for(int i = 0; i < t+1; i++){
            list[i] = new ArrayList<>();
        }
        int[] dist = new int[t+1];
        Arrays.fill(dist, 10000001);
        while(c-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.c > dist[n.b]) continue;
            for(Node next : list[n.b]){
                if(dist[next.b] > dist[n.b] + next.c){
                    dist[next.b] = dist[n.b] + next.c;
                    pq.add(new Node(next.b, dist[next.b]));
                }
            }
        }
        System.out.println(dist[e]);
    }
    static class Node implements Comparable<Node>{
        int b;
        int c;
        Node(int b, int c){
            this.b = b;
            this.c = c;
        }
        @Override
        public int compareTo(Node n1){
            return this.c - n1.c;
        }
    }
}
