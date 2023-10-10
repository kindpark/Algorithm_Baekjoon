import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] lof = new int[n];
		for(int i = 0; i < n; i++) {
			lof[i] = sc.nextInt();
		}
		Arrays.sort(lof);
		int[] weight = new int[n];
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				weight[i] += lof[i];
			}
		}
		Arrays.sort(weight);
		System.out.println(weight[n-1]);
		
	}
}