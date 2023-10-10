import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int P[] = new int[N];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		int res = 0;
		int result[] = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <=i; j++) {
				result[i] += P[j];
			}
		}
		for(int i = 0; i < N; i++) {
			res += result[i];
		}
		bw.write(String.valueOf(res));
		bw.flush();
		
	}
}