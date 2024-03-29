import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[2];
		StringBuilder res =new StringBuilder();
		for(int i = 0; i < s.length; i++) {
			s[i] = br.readLine();
		}
		int[][] dp = new int[s[0].length()+1][s[1].length()+1];
		for(int i = 1; i <= s[0].length(); i++) {
			for(int j = 1; j <= s[1].length(); j++) {
				if(s[0].charAt(i-1) == s[1].charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i][j]));
				}
			}
		}
		int a = s[0].length();
		int b = s[1].length();
		StringBuilder sb = new StringBuilder();
		while(a > 0 && b > 0) {
			if(s[0].charAt(a-1) == s[1].charAt(b-1)) {
				sb.insert(0, s[0].charAt(a-1));
				if(res.length() == dp[a][b]) {
					System.out.print(sb.toString());
					break;
				}
				a--;
				b--;
			}
			else {
				if(dp[a-1][b] > dp[a][b-1]) {
					a--;
				}
				else {
					b--;
				}
			}
		}
		/*
		int m = 1;
		for(int i = 1; i <= s[0].length(); i++) {
			for(int j = m; j <= s[1].length(); j++) {
				if(s[0].charAt(i-1) == s[1].charAt(j-1)) {
					res.append(s[0].charAt(i-1));
					m = j+1;
					break;
				}
			}
		}
		*/
		System.out.println(dp[s[0].length()][s[1].length()]);
		System.out.println(sb.toString());
	}
}