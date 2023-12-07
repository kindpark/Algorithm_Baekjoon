import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//6개
		int[] pack = new int[m];
		int[] seperate = new int[m];
		int res = 0;
		for(int i = 0; i < m; i++) {
			pack[i] = sc.nextInt();
			seperate[i] = sc.nextInt();
		}
		Arrays.sort(pack);
		Arrays.sort(seperate);
		res = Math.min(Math.min(pack[0] * (n/6+1), n*seperate[0]), pack[0] * (n/6) + (n%6)*seperate[0]);
		System.out.println(res);
	}
}