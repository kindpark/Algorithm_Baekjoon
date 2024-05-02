import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char map[][];
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(map[i][j])) {
                    int cur = map[i][j] - '0';
                    check(i, j, cur);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*' || map[i][j] == '#') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    /* 8방향 체크 */
    public static void check(int x, int y, int cur) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[nx][ny] == '#' && cur != 0) {
                cur--;
                map[nx][ny] = '*';
            } else if (map[nx][ny] == '*' && cur != 0) {
                cur--;
            } else if (map[nx][ny] == '#' && cur == 0) {
                map[nx][ny] = '-';
            }
        }
    }
}
