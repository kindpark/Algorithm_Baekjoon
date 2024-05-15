import java.io.*;
import java.util.*;

public class Main{
	static int n, m;
	static long[] tree,arr;
	static boolean change = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		tree = new long[n*4];
		//선형적인 배열을 세그먼트 트리로 변경
		init(0, n-1, 1);
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int change = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken())-1;
			int num = Integer.parseInt(st.nextToken())-1;
			if(change == 0) {	
				if(index<= num) {
					bw.write(String.valueOf(segmentSum(0, n-1, 1, index, num))+'\n');
				}
				else {
					bw.write(String.valueOf(segmentSum(0, n-1, 1, num, index))+'\n');
				}
			}else {
				//상동		
				update(0, n-1, 1, index, num+1);
				arr[index] = num+1;
			}
		}		
		bw.flush();
		br.close();
		bw.close();
	}
    
	static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
    
	static long update(int start, int end, int node, int index, long diff) {
		if(start > index || index > end) {
			return tree[node];
		}
		if(start == end) {
			return tree[node] = diff;
		}
		int mid = (start+end)/2;
		return tree[node] = update(start, mid, node*2, index, diff) + update(mid+1, end, node*2+1, index, diff);
		
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
}
