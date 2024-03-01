import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		double l = n * 0.15;
		int ll = (int) Math.round(l);
		int m = 0;
		int[] level = new int[n];
		for(int i = 0; i < n; i++) {
			level[i] =Integer.parseInt(br.readLine());
		}
		Arrays.sort(level);
		for(int i = ll; i < n - ll; i++) {
			sum += level[i];
			m++;
		}
		double res = sum / (m * 1.0);
		bw.write(String.valueOf(Math.round(res)));
		bw.flush();
	}
}