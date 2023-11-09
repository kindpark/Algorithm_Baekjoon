import java.util.*;
import java.io.*;
public class Main {
	static long res = 0;
	static long[] arr = new long[1000001];
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 1000000; i++) {
			for(int j = 1; i * j <= 1000000; j++) {
				//본인 값을 더함
				arr[i*j] += i;
			}
			//이전까지의 합
			arr[i] += arr[i-1];
		}
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n] + "\n");
			
		}
		System.out.println(sb.toString());
		
	}
}