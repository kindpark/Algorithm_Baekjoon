
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String a = br.readLine();
		st = new StringTokenizer(a, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] k = new int[m];
		int[] l = new int[m];
		int[] t = new int[m];
		int res[] = new int[n+1];
		a = br.readLine();
		st = new StringTokenizer(a," ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res[1] = arr[0];
		for(int i = 2; i <= n; i++) {
			res[i] = arr[i-1] + res[i-1];
		}
		for(int i = 0; i < m; i++) {
			a = br.readLine();
			st = new StringTokenizer(a, " ");
			k[i] = Integer.parseInt(st.nextToken());
			l[i] = Integer.parseInt(st.nextToken());
			t[i] = res[l[i]] - res[k[i]-1]; 
		}
		for(int i = 0; i < m; i++) {
			bw.write(t[i]+"\n");
		}
		bw.flush();
	}
}