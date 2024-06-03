import java.util.*;
import java.io.*;
//백트래킹 아니면 시간초과일것 같고 이걸 dp로 어떻게 해결하는지 몰라 답을 봤음
//https://velog.io/@zeesouth/%EB%B0%B1%EC%A4%80-2098.-%EC%99%B8%ED%8C%90%EC%9B%90-%EC%88%9C%ED%9A%8C-Java
public class Main {
    static int n;
    static final int inf = 999999999;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        //왜 비트마스크인지 알겠으나 비트마스크는 어렵다
        dp = new int[n][(1 << n)-1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //백트래킹으로 풀면 무조건 시간초과
        //비트마스크랑 dp 쓰라는데 뭔지 모름
        //비트마스크를 통해 방문했던 경로를 어떻게 표현할까?
        //ex) 0~3번 도시가 있다고 하면 1101(2)는 0,2,3번 도시를 방문한 상태
        //1101(2)를 10진수 형태로 바꾸면 2^3+2^2+2^0=8+4+1=13(10)이다.
        //즉 이진수에서 0은 방문을 안한 도시이고, 1은 방문한 도시라고 할 수 있음.
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        bw.write(dfs(0, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int dfs(int now, int visit){
        if(visit == (1<<n)-1){
            if(map[now][0] == 0){
                return inf;
            }
            return map[now][0];
        }
        if(dp[now][visit] != -1) {
            return dp[now][visit];
        }
        dp[now][visit] = inf;
        for(int i = 0; i < n; i++){
            //now > 아직 방문하지 않은 i번 가는 경로가 있는 경우
            if ((visit & (1 << i)) == 0 && map[now][i] != 0) {
                // d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때,
                // 방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용.
                // 즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
                dp[now][visit] = Math.min(dfs(i,visit | (1<<i))+map[now][i], dp[now][visit]);
            }
        }
        return dp[now][visit];
    }

}