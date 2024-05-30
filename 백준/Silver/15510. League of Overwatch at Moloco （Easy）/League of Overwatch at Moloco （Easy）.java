import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] ground;
    static int[] dist;
    static boolean chk = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ground = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ground[i] = new ArrayList<>();
        }

        if (n == 1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ground[x].add(y);
            ground[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] != 0) continue;
            dist[i] = 1;
            dfs(i);
        }

        if (chk) System.out.println("POSSIBLE");
        else System.out.println("IMPOSSIBLE");
    }
        static void dfs(int cur) {
        for (int x : ground[cur]) {
            if (dist[x] != 0) {
                if (((dist[cur] + dist[x]) & 1) == 0) chk = false;
            } else {
                dist[x] = dist[cur] + 1;
                dfs(x);
            }
        }
    }
}