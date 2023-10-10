import java.util.*;
import java.io.*;
 
public class Main {
    static int n;   // 노드 갯수
    static int k;   // 간선 갯수
    static int[] d;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int tc = Integer.parseInt(br.readLine());
 
        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n+1];
 
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            for(int i=0; i<n+1; i++)
                list.add(new ArrayList<Integer>());
 
            int[] indegree = new int[n+1];
 
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                d[i] = Integer.parseInt(st.nextToken());
    
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
    
                // v1 -> v2
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
    
                list.get(v1).add(v2);
                indegree[v2]++;
            }
 
            int w = Integer.parseInt(br.readLine());
    
            topologicalSort(indegree, list, w);    
        }
    }
 
    static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[n+1];
 
        // 건물의 기본 소요시간
        for(int i=1; i<=n; i++) {
            result[i] = d[i];
 
            if(indegree[i] == 0)
                q.offer(i);
        }
 
        // 건물 총 소요시간
        while(!q.isEmpty()) {
            int node = q.poll();
 
            for(Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + d[i]);
                indegree[i]--;
 
                if(indegree[i] == 0)
                    q.offer(i);
            }
        }
 
        System.out.println(result[w]);
    }
}