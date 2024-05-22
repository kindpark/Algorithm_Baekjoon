import java.io.*;
import java.util.*;

public class Main {
	static int[][] a;
	static int[][] dist;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(a[i][k] == 1 && a[k][j] == 1) {
						a[i][j] = 1;
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(String.valueOf(a[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}