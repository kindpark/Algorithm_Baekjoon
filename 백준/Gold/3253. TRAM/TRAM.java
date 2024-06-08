import java.util.*;
import java.io.*;

public class Main{
    static int n, a, b;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int res = 0;
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> neighbors = new ArrayList<>();
            while (k-- > 0) {
                int c = Integer.parseInt(st.nextToken());
                neighbors.add(c - 1);
            }
            list.add(neighbors);
        }
        bw.write(String.valueOf(djikstra()));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int djikstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n];
        Arrays.fill(dist, 100000000);
        dist[a-1] = 0;
        pq.add(new Node(a-1, 0));
        while(!pq.isEmpty()){
            Node nd = pq.poll();
            if(nd.a == b-1){
                return nd.b;
            }
            for (int i = 0; i < list.get(nd.a).size(); i++){
                int neighbor = list.get(nd.a).get(i);
                int next = nd.b + (i==0 ? 0:1);
                if(next < dist[neighbor]){
                    dist[neighbor] = next;
                    pq.add(new Node(neighbor, next));
                }
            }
        }
        return dist[b-1] == 100000000 ? -1 : dist[b-1];
    }

    static class Node implements Comparable<Node>{
        int a;
        int b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Node n1){
            return this.b - n1.b;
        }
    }
}
