import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//0이 뜰때까지 계속 루프를 돌리면 시간초과인것은 상식..
		//중간 이후는 전혀 상관없음 배열길이 4 기준 0, 1만 순환
		//logn를 씌우면 몇번 n으로 나눠야 0이 되는지 판단가능
		//때문에 2로 나누고, 버림을 했기에 1을 더함
		for(int i = 0; i < (n+1)/2; i++) {
			res += (int)(log2(arr[i], 2));
		}
		System.out.println(res+1);
		
	}
	//log2
	public static double log2(double x, double base) {
		return Math.log10(x)/Math.log10(base);
	}
}