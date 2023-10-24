import java.util.*;
import java.io.*;
public class Main {
	static int[] score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		score = new int[1000001];
		boolean[] isVisible = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			isVisible[arr[i]] = true;
		}
		
		for(int i = 1; i < n+1; i++) {
			num = arr[i];
			for(int j = num*2; j <1000001; j+= num) {
				
				if(isVisible[j]) {
					score[num]++;
					score[j]--;
				}
			}
		}
		for(int i : arr) {
			if(i != 0)
				sb.append(score[i] + " ");
		}
		System.out.println(sb.toString());
	}
}