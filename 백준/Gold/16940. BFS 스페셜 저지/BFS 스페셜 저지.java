import java.util.*;
import java.io.*;
public class Main{
    static boolean[] check;
    static int n, index = 1;
    static int[] ans1;
    static ArrayList<ArrayList<Integer>> node;
    static HashSet<Integer> set =  new HashSet<>();
    static Queue<Integer> qq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        node = new ArrayList<>();
        check = new boolean[n+1];
        for(int i = 0; i <= n; i++)
            node.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node.get(a).add(b);
            node.get(b).add(a);
        }
        st = new StringTokenizer(br.readLine());
        ans1 = new int[n];
        for (int i = 0; i < ans1.length; i++) {
            ans1[i] = Integer.parseInt(st.nextToken());
        }
        if (ans1[0] != 1){
            System.out.println(0);
            System.exit(0);
        }
        qq.add(1);
        check[1] = true;
        System.out.println(bfs());
    }
    public static int bfs(){
        while(!qq.isEmpty()){
            int a = qq.poll();
            for(int i : node.get(a)){
                if(!check[i]){
                    check[i] = true;
                    set.add(i);
                }
            }
            int size = set.size();
            for(int i = index; i < index+ size; i++) {
                if(set.contains(ans1[i]))
                    qq.add(ans1[i]);
                else return 0;
            }
            index+=size;
            set.clear();
        }
        return 1;
    }
}
