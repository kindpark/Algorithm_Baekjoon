import java.io.*;
import java.util.*;

class Now{
    int i;
    int j;
    int dis;
    boolean broken_wall;
    Now(int i, int j,int dis, boolean broken_wall)
    {
        this.i = i;
        this.j = j;
        this.dis = dis;
        this.broken_wall = broken_wall;
    }

}
class Main {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int n;
    static int m;
    static int ans = -1;

    static void bfs(int[][] map)
    {
        // check[][][0] : 벽을 부수지 않은 경우 방문 처리
        // check[][][1] : 벽을 부순 경우 방문 처리
        boolean[][][] check = new boolean[n][m][2];
        Queue<Now> q = new LinkedList<>();
        // 첫번째 방문지 세팅
        q.add(new Now(0, 0, 1,false));
        check[0][0][0] = true;

        while (!q.isEmpty())
        {
            // 현재 방문지의 위치
            Now now = q.poll();
            int i = now.i;
            int j = now.j;
            // 만약 현재 방문지가 도착지면 ans 저장하고 탈출
            if (i == n - 1 && j == m - 1)
            {
               ans = now.dis;
               break;
            }
            // 현재 방문지 상하좌우를 방문
            for (int k = 0; k < 4; k++)
            {
                int i2 = i + di[k];
                int j2 = j + dj[k];
                // 인접한 곳이 index 범위내인 경우
                if (i2 >= 0 && i2 < n && j2 < m && j2 >= 0)
                {
                    // 만약 인접한 곳이 벽이 아닌 경우
                    if (map[i2][j2] == 0)
                    {
                        // 만약 벽을 부순적이 있고 지나간 적이 없는 경우
                        if (now.broken_wall && !check[i2][j2][1])
                        {
                            // 방문처리 후 거리값 +1 해주고 큐에 넣기
                            check[i2][j2][1] = true;
                            q.add(new Now(i2, j2, now.dis + 1, true));
                        }
                        // 만약 벽을 부순적이 없고 지나간 적이 없는 경우
                        else if (!now.broken_wall && !check[i2][j2][0])
                        {
                            // 방문처리 후 거리값 +1 해주고 큐에 넣기
                            check[i2][j2][0] = true;
                           q.add(new Now(i2, j2, now.dis + 1, false));
                        }
                    }
                    // 만약 인접한 곳이 벽인 경우
                    else {
                        // 만약 벽을 부순적이 없고 지나간 적이 없는 경우
                        if (!now.broken_wall && !check[i2][j2][0])
                        {
                            // 방문처리 후 거리 +1 해주고 벽을 부쉈다는 표시하고 큐에 넣기
                            check[i2][j2][0] = true;
                            q.add(new Now(i2, j2, now.dis + 1, true));
                        }
                    } 
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = s.charAt(j) - '0';
        }
        bfs(map);
        // ans = -1로 시작하기 때문에 방문하지 못하면 -1이고 방문한 경우 값이 바뀌어서 나옴
        System.out.println(ans);
    }
}
