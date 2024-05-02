import java.util.*;
import java.io.*;
public class Main {
	static int n, res=0;
	static char[][] board;
    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(Character.isDigit(board[i][j])) {
					int cur = board[i][j] - '0';
					search(i, j, cur);
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == '*' || board[i][j] == '#') {
					res++;
				}
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
	public static void search(int x, int y, int bomb) {
		for(int i = 0; i < 8; i++) {
			int px = dx[i] + x;
			int py = dy[i] + y;
			if(px < 0 || py < 0 || px >= n || py >= n) continue;
			if(board[px][py] == '#' && bomb != 0) {
				bomb--;
				board[px][py] = '*';
			}
			else if(board[px][py] == '*' && bomb != 0) {
				bomb--;
			}
			else if(board[px][py] == '#' && bomb == 0) {
				board[px][py] = 'X';
			}	
		}
	}
}