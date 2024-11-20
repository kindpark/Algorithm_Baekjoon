import java.util.*;
import java.io.*;
public class Main{
    static int p, w, c, v, res=0;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        parents = new int[p];
        for(int i = 0; i < p; i++){
            parents[i] = i;
        }
        //갈 수 있는 길 중 큰 길만 골라간다.
        //그래서 경로상 길의 최대 우섡 순위 큐를 쓴다
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        int[] num;
        for(int i = 0; i < w; i++){
            st = new StringTokenizer(br.readLine());
            num = new int[st.countTokens()];
            for(int j = 0; j < num.length; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }
            pq.add(num);
        }

        while(find(c) != find(v)) {
            int[] arr = pq.poll();
            //서로 같지 않으면 분리집합
            if (find(arr[0]) != find(arr[1])) {
                union(arr[0], arr[1]);
                res = arr[2];
            }
        }
        System.out.println(res);
        br.close();

        }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            parents[px] = py;
        }
    }
    static int find(int x){
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}