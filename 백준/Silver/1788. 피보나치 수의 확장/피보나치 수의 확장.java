import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int flag1 = 1, flag2 = 1;
		
		if (N == 0 || N == 1) {
			System.out.println(N);
			System.out.println(N);
			return;
		}
        //무턱대고 무지성 -1만 박는게 아니라, 홀수는 + 짝수는 -와 같은 규칙이 있었음
		if (N < 0) {
			N = (-1) * N;
			if(N % 2 == 0)
				flag1 = -1;
		}
		int[] arr = new int[N+2];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000000;
		}
		System.out.println(flag1);
		System.out.println(arr[N] % 1000000000);
	
	}
}
