import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n+1];
		long[] sum = new long[n+1];
		long[] c = new long[m];
		long res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] + sum[i-1];
			//초기화 안해주면 long값을 넘는 문제 발생
			sum[i]%=m;
			if(sum[i] == 0) {
				res++;
			}
			c[(int)sum[i]%m]++;
		}
		/*
		c[i] * (c[i] - 1) / 2는 현재 나머지에 대한 합이 m으로 나누어 떨어지는 부분 배열의 개수를 계산합니다.
		이것은 조합을 이용한 계산으로, c[i]는 나머지가 i인 부분 배열의 개수를 나타내며, 각각의 부분 배열은 서로 다른 쌍을 형성할 수 있습니다.
		그러나 각 부분 배열은 자기 자신과의 쌍도 있으므로, 각각의 부분 배열은 (c[i] - 1)개의 다른 부분 배열과 쌍을 이룰 수 있습니다.
		이 때 c[i] * (c[i] - 1) / 2는 i번째 나머지에 대한 합이 m으로 나누어 떨어지는 부분 배열의 쌍의 수를 나타냅니다.
		각각의 나머지에 대해 이러한 쌍의 수를 계산하고, 모든 나머지에 대해 쌍의 수를 합산하여 총 부분 배열의 개수를 구합니다.
		따라서 res에 각 나머지에 대한 합이 m으로 나누어 떨어지는 부분 배열의 쌍의 수를 누적하여 더합니다.
		이것은 합이 m으로 나누어 떨어지는 부분 배열의 개수를 효과적으로 계산하기 위한 방법 중 하나입니다.
		*/
		for(int i = 0; i < m; i++) {
			res += c[i]*(c[i]-1)/2;
		}
		System.out.println(res);
	}
}