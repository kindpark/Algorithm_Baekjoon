import java.io.*;
import java.util.*;

public class Main {
	static int max = 10000000;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n+1];
		int[] res = new int[10001];
		for(int i = 1; i <= k; i++) {
			res[i] = 10000000;
		}
		for(int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			for(int j = coin[i]; j <= k; j++) {
				res[j] = Math.min(res[j], res[j-coin[i]]+1);
			}
		}
		if(res[k] == max) {
			System.out.println(-1);
		}else {
			System.out.println(res[k]);
		}
		sc.close();
	}
}