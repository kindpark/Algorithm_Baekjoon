import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		int r = 0;
		int p = 0;
		if(n == 1) {
			System.out.println(res);
		}
		else {
			while(n>1) {
				for(int i = 1; i < n; i++) {
					if(num[i] > r) {
						r = num[i];
						p = i;
					}
				}
				if(r < num[0]) {
					System.out.println(res);
					break;
				}
				else {
					num[0]++;
					num[p]--;
					r--;
					res++;
				}
			}
		}
	}
}