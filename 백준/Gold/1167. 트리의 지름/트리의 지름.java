import java.util.*;
 
public class Main {    
     static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        list = new ArrayList[n + 1]; 
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            int s = scan.nextInt();
            while(true) {
                int e = scan.nextInt();
                if(e == -1) break;
                int cost = scan.nextInt();
                list[s].add(new Node(e, cost));
            }
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(node, 0);
        
        System.out.println(max);
    }
    
    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;
        
        for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(visited[n.e] == false) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }
        
    }
    
    public static class Node {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
//블로그 참조 매우 많이 했습니다. https://moonsbeen.tistory.com/101
