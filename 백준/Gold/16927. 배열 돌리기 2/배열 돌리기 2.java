import java.io.*;
import java.util.*;
public class Main {
	static int n, m, r;
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		spinArrays();
		System.out.println(sb);
	}
	public static void spinArrays() {
		sb = new StringBuilder();
		for (int cnt = 0; cnt < Math.min(n, m) / 2 ; cnt++) {
			int rCnt = r % (2 * ((n - 1 - cnt * 2) + (m - 1 - cnt * 2)));

			for (int i = 0; i < rCnt; i++) {
				int save = arr[cnt][cnt];
				for (int j = cnt; j < m - 1 - cnt; j++)
					arr[cnt][j] = arr[cnt][j + 1];
				for (int j = cnt; j < n - 1 - cnt; j++)
					arr[j][m - cnt - 1] = arr[j + 1][m - cnt - 1];
				for (int j = m - 1 - cnt; j > cnt; j--)
					arr[n - cnt - 1][j] = arr[n - cnt - 1][j - 1];
				for (int j = n - 1 - cnt; j > cnt; j--)
					arr[j][cnt] = arr[j - 1][cnt];
				arr[cnt + 1][cnt] = save;
			}
		}
		for (int[] mp : arr) {
			for (int v : mp)
				sb.append(v + " ");
			sb.append("\n");
		}
	}
}
