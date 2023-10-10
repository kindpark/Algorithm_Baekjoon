import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt(), t = 0; char c, s[] = new char[n];
		String str = sc.next();
		while(n-->0){
			do{
				c = str.charAt(str.length()-n-1);
			} while (c < 48 || 57 < c);
			while (k > 0 && t > 0 && s[t - 1] < c) { t--; k--; }
			s[t++] = c;
		}
		t-=k; sc.close();
		for(k=0;k<t;k++) System.out.print(s[k]);
	}
}