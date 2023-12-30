import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		String n = sc.next();
		char[] a = n.toCharArray();
		for(int i = 0; i < n.length(); i++) {
			sum += Integer.parseInt(String.valueOf(n.charAt(i)));
		}
		Arrays.sort(a);
		if(a[0] != '0') {
			System.out.println(-1);
		}
		else if(sum % 3 != 0) {
			System.out.println(-1);
		}
		else {
			for(int i = a.length-1; i >= 0; i--) {
				System.out.print(a[i]);
			}
		}
	}
}