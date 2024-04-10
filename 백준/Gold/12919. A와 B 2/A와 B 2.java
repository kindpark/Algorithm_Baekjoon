import java.io.*;
public class Main {
	static int ans = 0;
	//a b 1과 풀이법 유사함
	//큰것을 작은것으로
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		stot(s, t);
		System.out.println(ans);
	}
	private static void stot(String s, String t) {
		if (s.length() == t.length()) {
			if (s.equals(t)) {
				ans = 1;
			}
			return;
		}
		if(t.charAt(0) == 'B') {
			String pashing = t.substring(1);
			StringBuilder sb = new StringBuilder(pashing);
			String s1 = sb.reverse().toString();
			stot(s, s1);
		}
		if(t.charAt(t.length() - 1) == 'A') {
			stot(s, t.substring(0, t.length()-1));
		}
		return;
	}
}