import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] x = new int[n+1];
		boolean[] yt = new boolean[1000001];
		Map<Integer, String> map = new HashMap<>();
		int[] y = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			y[i] = Integer.parseInt(st.nextToken());
		}
        //기본값 false로 설정
		for(int i = 0; i < m; i++) {
			map.put(y[i], "EI");
		}
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j< n; j++) {
				//xj에 해당되는것만 true로 돌린다.
				sum += x[j];
				map.put(sum, "JAH");
			}
			
		}
		for(int i = 0; i < m; i++) {
			//map만큼 print
			bw.write(map.get(y[i])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}