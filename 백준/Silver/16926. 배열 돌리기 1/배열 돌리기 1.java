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
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void spinArrays() {
		sb = new StringBuilder();
		for (int i = 0; i < Math.min(n, m) / 2 ; i++) {
			int rCnt = r % (2 * ((n - 1 - i * 2) + (m - 1 - i * 2)));

			for (int j = 0; j < rCnt; j++) {
				int save = arr[i][i];
				for (int k = i; k < m - 1 - i; k++)
					arr[i][k] = arr[i][k + 1];
				for (int k = i; k < n - 1 - i; k++)
					arr[k][m - i - 1] = arr[k + 1][m - i - 1];
				for (int k = m - 1 - i; k > i; k--)
					arr[n - i - 1][k] = arr[n - i - 1][k - 1];
				for (int k = n - 1 - i; k > i; k--)
					arr[k][i] = arr[k - 1][i];
				arr[i + 1][i] = save;
			}
		}
		for (int[] mp : arr) {
			for (int v : mp)
				sb.append(v + " ");
			sb.append("\n");
		}
	}
}
