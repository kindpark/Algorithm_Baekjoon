import java.util.*;
public class Main {
	public static void main(String[] args) {	
		int p = 1;
		int l = 0;
		int ans = 0;
		Scanner sc = new Scanner(System.in);
		String f = sc.next();
		String rf = new StringBuffer(f).reverse().toString();
		if(rf.equals(f)) {
			ans = f.length();
		}
		else {
			ans = f.length() * 2 - makePalindrome(rf);
 		}
		
		System.out.println(ans);
	}
	public static int makePalindrome(String s) {
		int n = 0;
		
		for(int i = 0; i < s.length(); i++) {
			String sp = s.substring(0, i);
			String rsp = new StringBuffer(sp).reverse().toString();
			if(sp.equals(rsp)) {
				n = sp.length();
			}
		}
		return n;
	}
}