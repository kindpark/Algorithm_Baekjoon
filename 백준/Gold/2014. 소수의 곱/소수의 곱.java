import java.io.*;
import java.util.*;
public class Main {
	static int k,n;
	static int MAX = 2147483647;
	static PriorityQueue<Long> pq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		long res=0;
		long[] arr = new long[k];
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			pq.add(arr[i]);
		}
		
		for(int g = 0; g < n; g++){
			res = pq.poll();
			
			for(int i = 0; i < k; i++) {
				if(res*arr[i] <= MAX) {
					pq.add(res*arr[i]);
					if(res%arr[i] == 0) {
						break;
					}
				}
			}

			
		}

		System.out.println(res);
	}
}