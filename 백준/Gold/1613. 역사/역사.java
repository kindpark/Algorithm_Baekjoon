import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] list;
	static int[][] line;
	static boolean[][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		check = new boolean[n+1][n+1];
		line = new int[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		int c1, c2;
		while(k-- >0) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			list[c1].add(c2);
			line[c1][c2] = 1;
			//list
		}
		//플로이드 워셜
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int l = 1; l <= n; l++) {
					//전후관계
					if(line[j][i] == 1&& line[i][l]==1) {
						line[j][l] = 1;
					}
				}
			}
		}
		int s = Integer.parseInt(br.readLine());
		while(s-- >0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a > n || b > n || a <= 0 || b <= 0) bw.write("0\n");
			else {
				if(line[a][b] == 1) {
					bw.write("-1\n");
				}
				else {
					if(line[b][a]==1) {
						bw.write("1\n");
					}
					else {
						bw.write("0\n");
					}
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}