import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static char[] grammer;
	static int[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = new int[26];
		for(int i = 0; i < n; i++) {
			String g = br.readLine();
			grammer = new char[g.length()];
			for(int j = 0; j < g.length(); j++) {
				check[g.charAt(j) - 'a']++;
			}
			dfs(g.length(), 0);
			Arrays.fill(check, 0);
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int length, int x) {
		if(x == length) {
			sb.append(grammer).append('\n');
			return;
		}
		else {
			for(int i = 0; i < 26; i++) {
				if(check[i] > 0) {
					check[i]--;
					grammer[x] = (char)(i+'a');
					dfs(length, x+1);
					//중복된 단어 체킹
					check[i]++;
				}
			}
		}
	}
}