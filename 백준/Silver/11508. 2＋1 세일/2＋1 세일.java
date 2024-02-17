import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		Integer[] price = new Integer[n];
		for(int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}
		Arrays.sort(price, Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			if(i % 3 != 2) {
				res+= price[i];
			}
		}
		System.out.println(res);
	}
}