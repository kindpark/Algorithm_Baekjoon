import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int count1, count2;
	static int[] mntree, mxtree, arr, min, max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
 		arr = new int[n+1];
		mntree = new int[300010];
		mxtree = new int[300010];
		for(int i=1; i<=n; i++) {
			arr[i] =Integer.parseInt(br.readLine());
		}
		init(1, n, 1);
		while(true) {
			if(m==0) 
                break;
			
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			long sum = minimum(1, n, 1, left, right);
			sb.append(sum+" ");
			sum = maximum(1, n, 1, left, right);
			sb.append(sum + "\n");
				
			m--;
			
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
    // 초기값 설정
	static void init(int start, int end, int node) {
		if(start == end) {
			mntree[node] = arr[start];
			mxtree[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		init(start, mid, node*2);
		init(mid+1, end, node*2 + 1);
		mntree[node] = Math.min(mntree[node*2], mntree[node*2+1]);
		mxtree[node] = Math.max(mxtree[node*2], mxtree[node*2 +1]);
	}
	static int minimum(int start, int end, int node, int l, int r) {
		if(r < start || l > end ) 
			return -1;
		if(l <= start && r >= end )
			return mntree[node];
		
		int mid = (start+end)/2;
		int v1 = minimum(start, mid, node*2, l, r);
		int v2 = minimum(mid+1, end, node*2+1,  l, r);
		if(v1 == -1) {
			return v2;
		}
		else if(v2 == -1) {
			return v1;
		}
		else {
			return Math.min(v1, v2);
		}
	}
	
	static int maximum(int start, int end, int node, int l, int r) {
		if(r < start || l > end ) 
			return -1;
		if(l <= start && r >= end )
			return mxtree[node];
		
		int mid = (start+end)/2;
	
		int v1 = maximum(start, mid, node*2, l, r);
		int v2 = maximum(mid+1, end, node*2+1,  l, r);
		if(v1 == -1) {
			return v2;
		}
		else if(v2 == -1) {
			return v1;
		}
		else {
			return Math.max(v1, v2);
		} 
	}
}