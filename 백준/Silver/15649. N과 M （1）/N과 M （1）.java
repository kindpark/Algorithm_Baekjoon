import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, res;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		res = new int[n+1];
		check = new boolean[n+1];
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		promise(0);
	}
	public static void promise(int c) {
		if(c == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				res[c] = arr[i];
				check[i] = true;
				promise(c+1);
				check[i] = false;
				
			}
		}
	}
}