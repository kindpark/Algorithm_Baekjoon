import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[] arr, tree;
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = 1;
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	static int query(int node, int start, int end, long order) {
		if(start == end) {
			return start;
		}
		int mid = (start + end) / 2;
		if(order <= tree[2*node]) {
			return query(2*node,start, mid, order);
		}
		else {
			return query(2*node+1, mid+1, end, order-tree[2*node]);
		}
	}
    
	static long update(int start, int end, int node, int del) {
		tree[node]--;
		if(start == end) {
			return 0;
		}
		else {
			int mid = (start + end) / 2;
			if(del <= mid) {
				return update(start, mid, 2*node, del);
			}
			else {
				return update(mid+1, end, 2*node+1, del);
			}
		}
	}
	
    // 구간 합 구하기
	static long segmentSum(int start, int end, int node, int l, int r) {	
		if(r < start || l> end ) {
			return 0;
		}
		if(l <= start && end <= r ) {
			return tree[node];
		}
		if(start == end) {
			return tree[node];
		}
		int mid = (start+end)/2;	
		return segmentSum(start, mid, node*2, l, r) + segmentSum(mid+1, end, node*2+1, l, r);  
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[1000000];
		long idx =1;
		init(1, n, 1);
		bw.write("<");
		for(int i = 0; i < n; i++) {
			int size = n-i;
			idx += m - 1;
			if(idx % size == 0) idx = size;
			else if(idx > size) idx %= size;
			int num = query(1, 1, n, idx);
			update(1, n, 1, num);
			if(i == n-1) bw.write(String.valueOf(num));
			else bw.write(String.valueOf(num)+", ");
		}
		bw.write(">");
		bw.flush();
		br.close();
		bw.close();
	}
}