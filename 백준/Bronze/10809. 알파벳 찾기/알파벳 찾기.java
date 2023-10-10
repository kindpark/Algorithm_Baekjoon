import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String N = in.nextLine();
		int[] alpha = new int[26];
		char[] a = new char[N.length()];
		for(int i = 0; i < N.length(); i++) {
			a[i] = N.charAt(i);
		}
		for(int i = 0; i < N.length(); i++) {
			for(int j = 0; j < alpha.length; j++) {
				if(a[i] == 97+j) {
					if(alpha[j] != 0) {
						break;
					}else {
						alpha[j] = i+1;
						break;
					}
				}
			}
		}
		for(int i = 0; i < alpha.length; i++) {
			System.out.printf("%d ", alpha[i]-1);
		}
	}
}
