import java.io.*;
import java.util.*;

public class Main {
    static int h, w, paper;
    static char[][] map;
    static boolean[][] check;
    static boolean[] key;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String hint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= Tc; T++) {
            key = new boolean[26];
            paper = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[111][111];
            check = new boolean[111][111];
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j-1);
                }
            }
            
            hint = br.readLine();
            for (int i = 0; i < hint.length(); i++) {
                if (hint.charAt(i) != '0') {
                    key[hint.charAt(i) - 'a'] = true;
                }
            }
            bfs(0, 0);
            System.out.println(paper);
        }
    }
    static class Node{
    	int x;
    	int y;
    	Node(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node>[] door = new Queue[26];
        for (int i = 0; i < 26; i++) {
            door[i] = new LinkedList<>();
        }
        
        q.add(new Node(x, y));
        check[x][y] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= h+1  && ny <= w+1) {
                    if (map[nx][ny] == '*' || check[nx][ny]) continue;
                    check[nx][ny] = true;

                    if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                        if (key[map[nx][ny] - 'A']) {
                            q.add(new Node(nx, ny));
                        } else {
                            door[map[nx][ny] - 'A'].add(new Node(nx, ny));
                        }
                    } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                        q.add(new Node(nx, ny));
                        if (!key[map[nx][ny] - 'a']) {
                            key[map[nx][ny] - 'a'] = true;
                            while (!door[map[nx][ny] - 'a'].isEmpty()) {
                                q.add(door[map[nx][ny] - 'a'].poll());
                            }
                        }
                    } else {
                        q.add(new Node(nx, ny));
                        if (map[nx][ny] == '$') paper++;
                    }
                }
            }
        }
    }

}