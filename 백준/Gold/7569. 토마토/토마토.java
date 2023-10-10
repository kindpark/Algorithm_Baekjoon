import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int M, N, H, ans;
	public static int tomato[][][];
	public static int dirs[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		int sum = 0;
		tomato = new int[N][M][H];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				tokens = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[j][k][i] = Integer.parseInt(tokens.nextToken());
					if (tomato[j][k][i] == 1) {
						q.add(new int[] { j, k, i, 0 });
					} else if (tomato[j][k][i] == -1) {
						sum++;
					}
				}
			}
		}

		ans = -1;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			sum++;
			for (int i = 0; i < dirs.length; i++) {
				int dx = temp[0] + dirs[i][0];
				int dy = temp[1] + dirs[i][1];
				int dz = temp[2] + dirs[i][2];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M && dz >= 0 && dz < H) {
					if (tomato[dx][dy][dz] == 0) {
						tomato[dx][dy][dz] = 1;
						q.add(new int[] { dx, dy, dz, temp[3] + 1 });
					}
				}
			}

			if (q.isEmpty() && sum == N * M * H) {
				ans = temp[3];
			}
		}

		System.out.println(ans);
	}
}