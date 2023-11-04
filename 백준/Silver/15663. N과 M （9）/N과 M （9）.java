import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, print;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		print = new int[n];
		arr = new int[n];
		check = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		promise(0);
	}
	public static void promise(int c) {
		if(c == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(print[i] + " ");
				
			}
			System.out.println();
		}
		int u = 0;
		for(int i = 0; i < n; i++) {
			if(!check[i] && arr[i] != u) {
				print[c] = arr[i];
				u = print[c];
				check[i] = true;
				promise(c+1);
				check[i] = false;
			}
		}
	}
}