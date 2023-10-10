import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long[] tree,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n+1];
		tree = new long[2100000];
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(0, n-1, 1);
		while(true) {
			if(m==0 && k==0) break;
			
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if(op ==1) {
				int idx = Integer.parseInt(st.nextToken())-1;
				long num = Long.parseLong(st.nextToken());
				//arr[idx] = num;
				//update(start, end, node, idx, before, after)
				//reset(0, n-1, 1);
				long before = arr[idx];
				
				update(0, n-1, 1, idx, num);
				arr[idx] = num;
				
				m--;
			}else {
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;
				
				long sum =pSum(0, n-1, 1, left, right);
				sb.append(sum+"\n");
				
				k--;
			}
		}
		
		System.out.println(sb.toString());
	}
	
    // 초기값 설정
	static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % 1000000007;
	}
	
	
    // 트리 수정
	static long update(int start, int end, int node, int idx, long val) {
		if(start > idx || idx > end) {
			return tree[node];
		}
		
		if(start == end) return tree[node] = val;
		
		int mid = (start+end)/2;
		return tree[node] = (update(start, mid, node*2, idx, val) * update(mid+1, end, node*2+1, idx, val)) % 1000000007;
		
	}
	
    // 구간 합 구하기
	static long pSum(int start, int end, int node, int l, int r) {
		
		if(r < start || l> end ) 
			return 1;
		if(l <= start && end <= r )
			return tree[node];
		
		int mid = (start+end)/2;
		
		return (pSum(start, mid, node*2, l, r) * pSum(mid+1, end, node*2+1, l, r)) % 1000000007;  
	}
}
