import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long res = 0; //30만 * 30만에 최댓값 100만
		Queue<Integer> q = new LinkedList<>(); 
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		ArrayList<Jewal> list = new ArrayList<>();
		int[] c = new int[k];
		boolean[] check1 = new boolean[k];
		boolean[] check2 = new boolean[n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Jewal(m, v));
		}
		for(int i = 0; i < k; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		Collections.sort(list);
		Arrays.sort(c);
		//반복문 1개로 줄여야할듯
		int idx = 0;
		for(int i = 0; i < k; i++) {
			while(idx < n && c[i] >= list.get(idx).m) {
				pq.add(list.get(idx).v);
				//System.out.println(list.get(idx).v);
				idx++;
			}
			if(!pq.isEmpty()) {
				res += pq.poll();
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		br.close();
		bw.close();
	}
	static class Jewal implements Comparable<Jewal>{
		int m;
		int v;
		Jewal(int m, int v){
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(Jewal o) {
			return m - o.m;
		}
		
	}
	static class Jewal1{
		int m;
		int v;
		Jewal1(int m, int v){
			this.m = m;
			this.v = v;
		}
	}
}
