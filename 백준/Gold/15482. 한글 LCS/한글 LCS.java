import java.util.*;
import java.io.*;
public class Main {
	static String s, cmp;
	static int[] check;
	static int r =0;
	static char[] ss;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j], dp[i][j-1]));
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}

}