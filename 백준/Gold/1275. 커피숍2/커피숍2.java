import java.io.*;
import java.util.StringTokenizer;

public class Main {
	//n = 수의 갯수
	static int n, m;
	static long[] tree,arr;
	static boolean change = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		//수의 변경이 일어나는 횟수
		m = Integer.parseInt(st.nextToken());
		//구간의 합을 구하는 횟수
		
		arr = new long[n+1];
		tree = new long[2100000];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//선형적인 배열을 세그먼트 트리로 변경
		init(0, n-1, 1);
		
		while(m != 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;	
			int index = Integer.parseInt(st.nextToken())-1;
			int num = Integer.parseInt(st.nextToken());		
			if(left > right) {
				int swap = left;
				left = right;
				right = swap;
			}
			sb.append(segmentSum(0, n-1, 1, left, right) + "\n");
			long different = num - arr[index];
			update(0, n-1, 1, index, different);
				
			arr[index] = num;
			m--;
			
		}
		
		System.out.println(sb.toString());
	}
    // 초기값 설정
	static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
    
	static void update(int start, int end, int node, int index, long different) {
		if(start <= index && index <= end) {
			tree[node] += different;
		}else {
			return;		
		}
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		update(start, mid, node*2, index, different);
		update(mid+1, end, node*2+1, index, different);
		
	}
	
    // 구간 합 구하기
	static long segmentSum(int start, int end, int node, int l, int r) {	
		if(r < start || l> end ) {
			return 0;
		}
		if(l <= start && end <= r ) {
			return tree[node];
		}
		int mid = (start+end)/2;	
		return segmentSum(start, mid, node*2, l, r) + segmentSum(mid+1, end, node*2+1, l, r);  
	}
}