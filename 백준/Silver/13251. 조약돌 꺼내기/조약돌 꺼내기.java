import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		double[] c = new double[n+1];
		int sum1 = 0;
		double sum2 = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum1 += arr[i];
		}
		int k = sc.nextInt();
		double result = 0.0;
		  for(int j = 0; j < n; j++)
		  {
		    double percent = 1.0;
		    if(arr[j] >= k)	// 선택 조약돌 개수보다 현재 색 조약돌 개수가 적으면 모두 같은 색으로 뽑힐 확률은 0
		    {
		      for(int i = 0; i < k; i++)
		      {
		        percent *= (double)(arr[j] - i) / (sum1 - i);
		      }
		      result += percent;	// 정답에 현재 색깔을 모두 뽑을 확률 더하기
		    }
		  }
		System.out.println(result);
		/*
		for(int i = 0; i < n; i++) {
			if(arr[i] >= k) {
				c[i] = factorial(arr[i], arr[i] - k) / factorial(k, 0);
				sum2 += c[i];
				System.out.println(c[i]);
			}
		}
		double sum3 = factorial(sum1, sum1-k) / factorial(k, 0);
		System.out.println(sum2 / sum3 * 1.0);
		*/
		
	}
}