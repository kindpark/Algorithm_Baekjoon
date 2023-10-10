
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String[] abc = str.split(" ");
		long a = Long.parseLong(abc[0]);
		long b = Long.parseLong(abc[1]);
		long c = Long.parseLong(abc[2]);
		System.out.println(dfs(a, b, c));
	}
	//깊이우선탐색
	public static long dfs(long a, long b, long c) {
		if(b == 1) {
			return a % c;
		}
		
		else if(b % 2 == 0) {
			long y = dfs(a, b/2, c);
			return (y*y)%c;
		}
        //나머지 왜곡 방지. a를 1번 더곱해줌
		else {
			long y = dfs(a, (b-1)/2, c);
			return ((y*y) % c )*a % c;
		}
	}
}