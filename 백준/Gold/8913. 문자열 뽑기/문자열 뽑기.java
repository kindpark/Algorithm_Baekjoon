import java.util.*;
import java.io.*;
public class Main {
	static boolean success;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			dp(s);
			if(success) {
				sb.append(1 + "\n");
				
			}
			else {
				sb.append(0 + "\n");
			}
            success = false;
		}
		System.out.println(sb.toString());
	}
	public static void dp(String s) {
		if(success) {
			return;
		}
		int stst = 1;
		int startIdx = 0;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i-1) == s.charAt(i)) {
				stst++;
			}
			else {
				if(stst >= 2) {
					dp(s.substring(0, startIdx) + s.substring(startIdx + stst, s.length()));
				}
				startIdx = i;
				stst = 1;
			}
		}
		if(s.length() >= 2 && s.length() == stst) {
			success = true;
			return;
		}
	}

}