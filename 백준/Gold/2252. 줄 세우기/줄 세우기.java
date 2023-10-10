import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();


    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b]++;
            edges.get(a).add(b);
        }

        for (int i = 1; i <= n; i++){
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int num = q.poll();
            bw.write(num+" ");
            for (int i = 0; i < edges.get(num).size(); i++) {
                int c = edges.get(num).get(i);
                arr[c]--;
                if(arr[c] == 0) {
                    q.add(c);
                }
            }
        }

        bw.close();
    }
}