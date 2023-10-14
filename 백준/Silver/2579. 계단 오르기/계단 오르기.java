import java.util.*;
import java.io.*;

public class Main{
	static int n, k;
	static int[] floor;
	static int[] dp;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		floor = new int[310];
		dp = new int[310];
		for(int i = 1; i <= n; i++) {
			floor[i] = sc.nextInt();
		}
		dp[1] = floor[1];
		dp[2] = floor[1] + floor[2];
		dp[3] = floor[3] + Math.max(floor[1], floor[2]);
		for(int i = 4; i <= n; i++) {
            //이전 계단 합들과 바로 전 계단의 합, 이이전 발자취 합을 비교하여 최댓값을 도출
			dp[i] = floor[i] + Math.max(floor[i-1] + dp[i-3], dp[i-2]);
		}
		System.out.println(dp[n]);
	}
}