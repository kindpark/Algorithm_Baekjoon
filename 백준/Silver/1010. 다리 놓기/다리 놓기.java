import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int ans;
		int arr[][] = new int[31][31];
		arr[0][0] = 1;
		arr[0][1] = 1;
		for(int i= 1; i < 31; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					arr[i][j] = 1;
				}else {
					
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
			
				}
			}
		}
		for(int i = 0; i < T; i++) {
			int N = in.nextInt();
			int M = in.nextInt();
			System.out.println(arr[M][N]);
		}
	}
}
