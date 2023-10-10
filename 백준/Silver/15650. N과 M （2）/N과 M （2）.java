
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int m;
	static int arr[] = new int[n];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String[] ab = a.split(" ");
		
		int n = Integer.parseInt(ab[0]);
		int m = Integer.parseInt(ab[1]);
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		boolean visited[] = new boolean[n+1];

		combination(arr, visited, 1, n, m);
		
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(arr, visited, n);
	        return;
	    } 

	    for(int i=start; i<=n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	static void print(int arr[], boolean[] visited, int n) {
		if(n == 0) {
			return;
		}
		else {
			for(int i = 0; i <=n; i++) {
				if(visited[i] == true) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}

}