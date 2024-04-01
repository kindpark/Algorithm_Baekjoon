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
		
		s = br.readLine();
		//체크가 필요있는가?
		check = new int[26];
		for(int i = 0; i < s.length(); i++) {
			check[s.charAt(i) - 97]+=1;
		}
		String ss = "";
		for(int i = 0; i < 26; i++) {
			if(check[i] > 0) {
				String sss = ss+(char)(i+97);
				check[i]-=1;
				dfs(s.length(), sss, 1);
				check[i]+=1;
			}
		}
		bw.write(String.valueOf(r));
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int len, String ss, int depth) {
		int d = 0;
		if(len == depth) {
			r++;
			return;
		}
		for(int i = 0; i < 26; i++) {
			if(check[i] >0 && (ss.charAt(depth-1) != ((char)(97+i)))) {
				cmp = ss + (char)(97+i);
				check[i]-= 1;
				dfs(len, cmp, depth+1);
				check[i] += 1;
			}
		}
	}
}
