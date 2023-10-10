import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int n, m, h;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    map[i][j] = 11; //치즈 경도는 최대 9이기 때문에 생쥐는 11로 표시
                } else if (str.charAt(j) == '.') {
                    map[i][j] = 0; //빈 공간은 0
                } else if (str.charAt(j) == 'X') {
                    map[i][j] = -1; //벽은 -1
                } else {
                    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }
        }
        q = new LinkedList<>();
        bfs(startX, startY);
    }

    private static void bfs(int x, int y) {
        q.add(new int[]{x, y, 0, map[x][y] - 10});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int xx = poll[0];
            int yy = poll[1];
            int cc = poll[2];
            int hh = poll[3];

            if (hh > h) {
                System.out.println(cc);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (map[nowX][nowY] > 0 && map[nowX][nowY] <= hh) {
                        //치즈를 먹었을 때는 visit과 q를 비워주고 다시 그 지점부터 시작해야 한다.
                        q.clear();
                        q.add(new int[]{nowX, nowY, cc + 1, hh + 1});
                        map[nowX][nowY] = 0;
                        check = new boolean[n][m];
                        break;
                    } else if (map[nowX][nowY] >= 0 && !check[nowX][nowY]) {
                        q.add(new int[]{nowX, nowY, cc + 1, hh});
                        check[nowX][nowY] = true;
                    }
                }
            }
        }
    }
}