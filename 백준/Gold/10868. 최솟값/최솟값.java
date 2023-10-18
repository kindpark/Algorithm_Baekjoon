import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] tree,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		tree = new int[2100000];
		for(int i=0; i<n; i++) {
			arr[i] =Integer.parseInt(br.readLine());
		}
		
		init(0, n-1, 1);
		while(true) {
			if(m==0) break;
			
			st = new StringTokenizer(br.readLine());
			//int op = Integer.parseInt(st.nextToken());
			//수 변경
			/*
			if(op ==1) {
				int idx = Integer.parseInt(st.nextToken())-1;
				int num = Integer.parseInt(st.nextToken());
				//arr[idx] = num;
				//update(start, end, node, idx, before, after)
				//reset(0, n-1, 1);
				long before = arr[idx];
				
				update(0, n-1, 1, idx, num);
				arr[idx] = num;
				
				m--;
			}
			//최솟값 출력
			else {
			*/
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;
				
				long sum =minimum(0, n-1, 1, left, right);
				sb.append(sum+"\n");
				
				m--;
			
		}
		
		System.out.println(sb.toString());
	}
	
    // 초기값 설정
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
	}
	
	
    // 트리 수정
	static int update(int start, int end, int node, int idx, int val) {
		if(start > idx || idx > end) {
			return tree[node];
		}
		
		if(start == end) return tree[node] = val;
		
		int mid = (start+end)/2;
		return tree[node] = update(start, mid, node*2, idx, val) + update(mid+1, end, node*2+1, idx, val);
		
	}
	
    // 구간 합 구하기
	static long pSum(int start, int end, int node, int l, int r) {
		
		if(r < start || l> end ) 
			return 1;
		if(l <= start && end <= r )
			return tree[node];
		
		int mid = (start+end)/2;
		
		return pSum(start, mid, node*2, l, r) +  pSum(mid+1, end, node*2+1, l, r);  
	}
	
	static int minimum(int start, int end, int node, int l, int r) {
		if(node >= tree.length-1) {
			return Integer.MAX_VALUE;
		}
		if(r < start || l > end ) 
			return Integer.MAX_VALUE;
		else if(l <= start && r >= end )
			return tree[node];
		
		int mid = (start+end)/2;
		return Math.min(minimum(start, mid, node*2, l, r) , minimum(mid+1, end, node*2+1, l, r));  
	}
}