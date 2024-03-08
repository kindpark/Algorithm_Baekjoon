import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[3];
		for(int i = 0; i < s.length; i++) {
			s[i] = sc.nextLine();
		}
		int[][][] dp = new int[s[0].length()+1][s[1].length()+1][s[2].length()+1];
		for(int i = 1; i <= s[0].length(); i++) {
			for(int j = 1; j <= s[1].length(); j++) {
				for(int k = 1; k <= s[2].length(); k++) {
					if(s[0].charAt(i-1) == s[1].charAt(j-1) && s[1].charAt(j-1) == s[2].charAt(k-1)) {
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}
					else {
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(dp[s[0].length()][s[1].length()][s[2].length()]);
	}
}
