import java.util.*;
import java.io.*;
public class Main {
	private static boolean[] prime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 0;
		prime = new boolean[100001];
		prime[0] = true;
		prime[1] = true;
		//소수 구하기
		for(int i = 2; i <= 100000; i++) {
			for(int j = i*2; j <= 100000; j+=i) {
				prime[j] = true;
			}
		}
		for(int i = a; i <= b; i++) {
			int c = lowMyIntelligence(i);
			if(!prime[c]) {
				cnt++;
			}
		
		}
		
		System.out.println(cnt);
	}
	public static int lowMyIntelligence(int i) {
		int count = 0;
		for (int j = 2; j <= i; j++) {
			if (!prime[j]&&i % j == 0) {
				i /= j;
				count++;
				j--;
			}
			if (i == 1)
				break;
		}
		return count;
	}
}