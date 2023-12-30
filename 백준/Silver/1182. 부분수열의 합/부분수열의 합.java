import java.util.*;
public class Main {
	static int res, n, s;
	static int[] arr, sel;
	static boolean[] used;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		res = 0;
		arr = new int[n];
		sel = new int[n];
		used = new boolean[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0, 0);
		System.out.println(res);
	}
	//백트래킹이니만큼 dfs로도 풀수있다.
	//
	public static void dfs(int a, int m) {
		if(a == n) {
			return;
		}
		//현재 단계의 배열과 그 합이 구하고자 한것과 같다면
		if(m + arr[a] == s) {
			res++;
		}
		dfs(a+1, m);
		dfs(a+1, m+arr[a]);
	}
}