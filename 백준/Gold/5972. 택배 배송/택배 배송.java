import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] dist;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 200000001);
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(Node next : list[n.b]){
                if( dist[next.b] > dist[n.b] + next.c){
                    dist[next.b] = dist[n.b] + next.c;
                    pq.add(new Node(next.b, dist[next.b]));
                }
            }
        }
        bw.write(String.valueOf(dist[n]));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Node implements Comparable<Node>{
        int b;
        int c;
        Node(int b, int c){
            this.b =b;
            this.c = c;
        }
        @Override
        public int compareTo(Node n2){
            return this.c - n2.c;
        }

    }
}