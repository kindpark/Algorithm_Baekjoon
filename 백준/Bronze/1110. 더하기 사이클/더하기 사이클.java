import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int a = 0, b = 0;
		int r = 0;
		int p = 0;
		String c = String.valueOf(n);
		if(c.length() == 1) {
			a = 0;
			b = Integer.parseInt(String.valueOf(c.charAt(0)));
			r = a + b;
			c = a + "+" + b + "=" +  r;
			for(int i = 0; i < c.length(); i++) {
				if(c.charAt(i) == '=') {
					p = i;
				}
			}
			a = Integer.parseInt(String.valueOf(c.charAt(p-1)));
			b = Integer.parseInt(String.valueOf(c.charAt(c.length() - 1)));
			c = String.valueOf(a);
			c += String.valueOf(b);
			r = Integer.parseInt(String.valueOf(c));
			cnt++;
		}
		else if(c.charAt(1) == '0') {
			a = Integer.parseInt(String.valueOf(c.charAt(0)));
			b = Integer.parseInt(String.valueOf(c.charAt(1)));
			r = a + b;
			c = a + "+" + b + "=" +  r;
			for(int i = 0; i < c.length(); i++) {
				if(c.charAt(i) == '=') {
					p = i;
				}
			}
			a = Integer.parseInt(String.valueOf(c.charAt(p-1)));
			b = Integer.parseInt(String.valueOf(c.charAt(c.length() - 1)));
			c = String.valueOf(a);
			c += String.valueOf(b);
			r = Integer.parseInt(String.valueOf(c));
			cnt++;
		}
		else {
			a = Integer.parseInt(String.valueOf(c.charAt(0)));
			b = Integer.parseInt(String.valueOf(c.charAt(1)));
			r = a + b;
			c = a + "+" + b + "=" +  r;
			for(int i = 0; i < c.length(); i++) {
				if(c.charAt(i) == '=') {
					p = i;
				}
			}
			a = Integer.parseInt(String.valueOf(c.charAt(p-1)));
			b = Integer.parseInt(String.valueOf(c.charAt(c.length() - 1)));
			c = String.valueOf(a);
			c += String.valueOf(b);
			r = Integer.parseInt(String.valueOf(c));
			cnt++;
		}
		while(r != n) {
			a = Integer.parseInt(String.valueOf(c.charAt(0)));
			b = Integer.parseInt(String.valueOf(c.charAt(1)));
			r = a + b;
			c = a + "+" + b + "=" +  r;
			for(int i = 0; i < c.length(); i++) {
				if(c.charAt(i) == '=') {
					p = i;
				}
			}
			a = Integer.parseInt(String.valueOf(c.charAt(p-1)));
			b = Integer.parseInt(String.valueOf(c.charAt(c.length() - 1)));
			c = String.valueOf(a);
			c += String.valueOf(b);
			r = Integer.parseInt(String.valueOf(c));
			cnt++;
		}
		System.out.println(cnt);
	}
	
	
}