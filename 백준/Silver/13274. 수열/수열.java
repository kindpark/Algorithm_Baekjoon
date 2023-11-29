import java.util.*;
import java.io.*;
public class Main{
	static int n,k;
	static long[] temp1, temp2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		temp1 = new long[n];
		temp2 = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0 ; i < k;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			long x = Long.parseLong(st.nextToken());
			sort(arr,l,r,x);
		}
		StringBuilder sb = new StringBuilder();
		for(long i : arr)
			sb.append(i+" ");
		System.out.println(sb.toString());

	}
	static void sort(long arr[],int l,int r,long k) {
	    int sub = r-l+1;
	    int left = 0;
	    int right = 0;
	    for(int i = 0 ; i < n; i++) {
	    	if(l <= i && i <= r)
	    		temp1[left++] = arr[i]+k;
	    	else
	    		temp2[right++] = arr[i];
	    }
	    left = 0;
	    right = 0;
	    int idx = 0;
	    while(left< sub && right < n-sub) {
	    	if(temp1[left] < temp2[right]) arr[idx++] =temp1[left++];
	    	else arr[idx++] = temp2[right++];
		
	    }
	
	    if(left == sub)
	    	for(int i = right; i < n-sub; i++){
	    		arr[idx++] = temp2[i];
            }
	    else
	    	for(int i = left; i < sub ; i++){
	    		arr[idx++] = temp1[i];
            }
	
}
}
