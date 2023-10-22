import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int n;
    static int[] expect;
    static ArrayList<ArrayList<Integer>> info;
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        info = new ArrayList<>();
        visit = new boolean[n + 1];
        expect = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info.get(from).add(to);
            info.get(to).add(from);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            expect[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
        System.out.println(1);
    }

    private static void dfs(int current, int index) {
        visit[current] = true;

        // 현재 값 뒤에 나올 수 있는 값들에 대한 정보를 저장.
        int count = 0;
        for (int nextCandidate : info.get(current)) {
            if (!visit[nextCandidate]) {
                visit[nextCandidate] = true;
                parent[nextCandidate] = current;
                count++;
            }
        }

        index++;
        for (int i = 0; i < count; i++) {
            int next = expect[index];
            if (parent[next] != current) {
                System.out.println(0);
                System.exit(0);
            }
            dfs(next, index);
        }
    }
}