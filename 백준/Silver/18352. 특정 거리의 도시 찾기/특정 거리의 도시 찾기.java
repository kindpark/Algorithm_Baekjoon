import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
    static int N, M, K, X;
    static int[] dist = new int[300001];
    
    public static void bfs(int x){
		dist[x] = 0;
        
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i=0; i<graph.get(now).size(); i++) {
			  int next=graph.get(now).get(i);
			  if(dist[next] == -1) {
			    dist[next]=dist[now]+1;
			    que.offer(next);
			  }
			}
		}
    }
    
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>()); // 연결리스트에 노드 추가;
			dist[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
		}
        
		bfs(X);
        
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=N; i++){
			if(dist[i] == K) sb.append(i + "\n");
		}
		System.out.println(sb.length() == 0 ? -1 : sb);
		
	}

}