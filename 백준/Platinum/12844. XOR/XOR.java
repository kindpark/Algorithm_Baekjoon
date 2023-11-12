import java.io.*;
import java.util.*;

public class Main{
	static int n, m, k;
	static long plus;
	static long[] tree,arr,lazy;
	static boolean change = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n+1];
		tree = new long[getTreeSize()+1];
		lazy = new long[getTreeSize()+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		//선형적인 배열을 세그먼트 트리로 변경
		init(0, n-1, 1);
		
		while(m != 0) {
			st = new StringTokenizer(br.readLine());
			int change = Integer.parseInt(st.nextToken());
			if(change == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());	
				plus = Long.parseLong(st.nextToken());
				
				
				update(0, n-1, 1, left, right, plus);
				
				m--;
			}
			else {
				//상동
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());			
				sb.append(segmentSum(0, n-1, 1, left, right) + "\n");
				m--;
			}
		}
		
		System.out.println(sb.toString());
	}
    
    // 트리 사이즈 구하기
	public static int getTreeSize() {
		//2^-1 부터 시작하는 트리를 고려
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
		return (int)Math.pow(2, h)-1;
	}
    // 초기값 설정
	public static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) ^ init(mid+1, end, node*2+1);
	}
    
	public static void update(int start, int end, int node, int left, int right, long plus) {
		lazyTree(node, start, end);
		if(left > end || right < start) {
			return;
		}
		if(start >= left && right >= end) {
			if((end -start + 1) % 2 == 1) {
				tree[node] ^= plus;
			}

	        if(start != end){
	            lazy[node*2] ^= plus;
	            lazy[node*2+1] ^= plus;
	        }
	            return;
		}
		int mid = (start+end)/2;
		update(start, mid, node*2, left, right, plus);
		update(mid+1, end, node*2+1, left, right, plus);
		tree[node] = tree[node*2] ^ tree[node*2 + 1];
		
	}
	public static void lazyTree(int node, int start, int end) {
		if(lazy[node]!=0){ // 만약 현재 노드에 lazy값이 있다면
            if((end-start+1) % 2 == 1) {
            	tree[node] ^= lazy[node];// 현재노드 업데이트
            }

            if(start != end) { // 만약 자식이 있다면 자식들에게 lazy값을 전파한다.
                lazy[node * 2] ^= lazy[node];
                lazy[node * 2 + 1] ^= lazy[node];
            }
        }
		lazy[node] = 0;
	}
    // 구간 합 구하기
	public static long segmentSum(int start, int end, int node, int l, int r) {	
		lazyTree(node, start, end);
		if(r < start || l> end ) {
			return 0;
		}
		if(l <= start && end <= r ) {
			return tree[node];
		}
		int mid = (start+end)/2;	
		return segmentSum(start, mid, node*2, l, r) ^ segmentSum(mid+1, end, node*2+1, l, r);  
	}
}