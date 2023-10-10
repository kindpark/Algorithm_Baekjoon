import java.util.*;
 
public class Main {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        Main m = new Main();
		int N = in.nextInt(); 
		arr = new char[N][N];        
    	m.print(0, 0, N, false);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	void print(int x, int y, int N, boolean center) {
		if (center) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) {
					print(i, j, size, true);
				} else {
					print(i, j, size, false);
				}
			}
		}
	}
}