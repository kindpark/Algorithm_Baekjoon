import java.util.*;
	
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[][] tw = new int[15][15];
		for(int i = 1; i < 15; i++) {
			tw[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				for(int k = 1; k <= j; k++) {
					tw[i][j] += tw[i-1][k];
				}
			}
		}
		for(int i = 0; i < t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(tw[k][n]);
		}
	}
}
