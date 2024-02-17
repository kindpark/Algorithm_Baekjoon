import java.util.*;
import java.io.*;
public class Main{
	static int[] tree;
	static int n, m, sum = 0;
	public static boolean right(int mid) {
		int rr = 0;
		for(int i = 0; i < n; i++) {
			if(tree[i] >= mid) {
				rr += (tree[i] - mid);
			}
			if(rr >= m) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//int sum, res = 0;
		int l=0, r=2000000000, mid, res = 0;
		tree = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		//이분 탐색
		while(l <= r) {
			mid = (l+r) /2;
			if(right(mid)) {
				res = mid;
				l = mid + 1;
			}
			else {
				r = mid-1;
			}
		}
		/*
		//시간초과 코드
		Arrays.sort(tree);
		for(int i = tree[n-1]; i >= 1; i--) {
			sum = 0;
			for(int j = 0; j < n; j++) {
				if(i >= tree[j]) {
					sum += 0;
				}
				else {
					sum += tree[j] - i;
				}
			}
			if(sum == m) {
				res = i;
				break;
			}
		}
		System.out.println(res);
		*/
		System.out.println(res);
	}
	
}