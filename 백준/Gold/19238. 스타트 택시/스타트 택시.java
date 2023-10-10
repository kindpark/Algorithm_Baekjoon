import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M, minDist;
    static long F;
    static boolean[][] map;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static final int INF = 1000;
    static Passenger taxiDriver = new Passenger(0, 0);
    static HashMap<Passenger, Boolean> passengerList = new HashMap<>();
    static PriorityQueue<Passenger> passengersNearby = new PriorityQueue<>((o1, o2) -> {
        if (o1.dist == o2.dist) {
            if (o1.x == o2.x) {
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.x, o2.x);
        }
        return Integer.compare(o1.dist, o2.dist);
    });
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
 
        map = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
 
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        }
        st = new StringTokenizer(br.readLine());
        taxiDriver.x = Integer.parseInt(st.nextToken());
        taxiDriver.y = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
 
            passengerList.put(new Passenger(px, py, 0, nx, ny), true);
        }
 
        while (M-- > 0) {
            updatePassengerList();
 
            int dist = passengersNearby.peek().dist;
            if (dist > F || dist == INF) {
                F = -1;
                break;
            }
            F -= dist;
 
            int sx = passengersNearby.peek().x;
            int sy = passengersNearby.peek().y;
            int ex = passengersNearby.peek().ex;
            int ey = passengersNearby.peek().ey;
            Passenger p = new Passenger(sx, sy, 0, ex, ey);
            passengerList.remove(p);
 
            minDist = INF;
            dist = getDist(sx, sy, ex, ey);
 
            if (dist > F || dist == INF) {
                F = -1;
                break;
            }
            F += dist;
            taxiDriver.x = ex;
            taxiDriver.y = ey;
        }
 
        bw.write(String.valueOf(F));
        br.close();
        bw.close();
    }
 
    public static void updatePassengerList() {
        passengersNearby.clear();
        minDist = INF;
 
        for (Passenger p : passengerList.keySet()) {
            int dist = getDist(taxiDriver.x, taxiDriver.y, p.x, p.y);
            minDist = Math.min(dist, minDist);
            passengersNearby.offer(new Passenger(p.x, p.y, dist, p.ex, p.ey));
        }
    }
 
    public static int getDist(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[sx][sy] = true;
        Queue<Passenger> q = new LinkedList<>();
        q.offer(new Passenger(sx, sy, 0));
 
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int dist = q.peek().dist;
            q.poll();
 
            if (dist > minDist) break;
            if (x == ex && y == ey) return dist;
 
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
 
                if (!isIn(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Passenger(nx, ny, dist + 1));
            }
        }
        return INF;
    }
 
    public static boolean isIn(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N || map[x][y]) return false;
        return true;
    }
 
    static class Passenger {
        int x;
        int y;
        int dist;
        int ex;
        int ey;
 
        public Passenger(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        public Passenger(int x, int y, int dist) {
            this(x, y);
            this.dist = dist;
        }
 
        public Passenger(int x, int y, int dist, int ex, int ey) {
            this(x, y, dist);
            this.ex = ex;
            this.ey = ey;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
 
            Passenger p = (Passenger) obj;
            return (p.x == x && p.y == y && p.dist == dist && p.ex == ex && p.ey == ey);
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y, dist, ex, ey);
        }
    }
}