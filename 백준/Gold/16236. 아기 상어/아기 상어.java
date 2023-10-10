import java.util.*;

public class Main {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N;
    public static int[][] map;
    public  static int[][] dist;
    public static int sharkSize = 2;
    public static int eatingCount = 0;
    public static int count = 0;
    public static int sharkX = -1;
    public static int sharkY = -1;
    public static int minX;
    public static int minY;
    public static int minDist;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = scanner.nextInt();

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            dist = new int[N + 1][N + 1];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eatingCount++;
                map[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                count += dist[minX][minY];

                if (eatingCount == sharkSize) {
                    sharkSize++;
                    eatingCount = 0;
                }
            } else {
                break;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (isInArea(newX, newY) && isAbleToMove(newX, newY) && dist[newX][newY] == 0) {
                    dist[newX][newY] = dist[p.x][p.y] + 1;

                    if (isEatable(newX, newY)) {
                        if (minDist > dist[newX][newY]) {
                            minDist = dist[newX][newY];
                            minX = newX;
                            minY = newY;
                        } else if (minDist == dist[newX][newY]) {
                            if (minX == newX) {
                                if (minY > newY) {
                                    minX = newX;
                                    minY = newY;
                                }
                            } else if (minX > newX) {
                                minX = newX;
                                minY = newY;
                            }
                        }
                    }

                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static boolean isAbleToMove(int x, int y) {
        return map[x][y] <= sharkSize;
    }

    private static boolean isEatable(int x, int y) {
        return map[x][y] != 0 && map[x][y] < sharkSize;
    }

    private static boolean isInArea(int x, int y) {
        return x <= N && x > 0 && y <= N && y > 0;
    }


    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}