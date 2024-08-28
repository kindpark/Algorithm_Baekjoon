import java.io.*;
import java.util.*;
//공부햇는데 아무리봐도 모르겠어서 타인 코드를 참고했습니다 꼭 다시풀게요
public class Main {
    static final int MAX_N = 801;
    static final int OUT = 400;
    static int N, P, ans;
    static int[][] flow = new int[MAX_N][MAX_N];
    static int[][] cap = new int[MAX_N][MAX_N];
    static List<Integer>[] grid = new ArrayList[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < MAX_N; i++) {
            grid[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            grid[i].add(i + OUT);
            grid[i + OUT].add(i);
            cap[i][i + OUT] = 1;
        }
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            grid[from + OUT].add(to);
            grid[to].add(from + OUT);
            cap[from + OUT][to] = 1;

            grid[to + OUT].add(from);
            grid[from].add(to + OUT);
            cap[to + OUT][from] = 1;
        }

        edmondsKarp();
        System.out.println(ans);
    }

    static void edmondsKarp() {
        while (true) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            int[] parent = new int[MAX_N];
            Arrays.fill(parent, -1);
            int minFlow = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : grid[cur]) {
                    if (cap[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        queue.add(next);
                        parent[next] = cur;

                        if (next == 2) {
                            break;
                        }
                    }
                }
            }

            if (parent[2] == -1) {
                break;
            }

            for (int i = 2; i != 401; i = parent[i]) {
                minFlow = Math.min(minFlow, cap[parent[i]][i] - flow[parent[i]][i]);
            }

            for (int i = 2; i != 401; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            ans += minFlow;
        }
    }
}