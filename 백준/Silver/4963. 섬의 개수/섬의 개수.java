import java.io.*;
import java.util.*;

public class Main{
	static StringBuilder sb;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
	static int h;
	static int w;
    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = " ";
        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);


            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            int island_count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        island_count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(island_count).append('\n');
        }
        System.out.println(sb);
    }

		
	
	
	static void dfs(int x, int y) {
	
		visit[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(0 <= xx && xx < h && 0 <= yy && yy < w) {
				if(map[xx][yy] ==1 && !visit[xx][yy]) {
					dfs(xx,yy);
				}
			}
		}
	}
}