//공부용으로 특정 소스 참고함
import java.io.*;
import java.util.*;
public class Main {
	static int[] v;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] norm = new int[n];
		int[] arr = new int[n];
		v = new int[n+1];
		int length=0, idx=0;
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for(int i=0; i<n; i++) {
			norm[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num =  Integer.parseInt(st.nextToken());
			arr[num-1] = i;
		}
		
		int[] res = new int[n];
		for(int i=0; i<n ;i++) {
			res[i] = arr[norm[i]-1]+1;
		}
		for(int i=0; i<n; i++) {
			if(res[i] > v[length]) {
				length +=1;
				v[length] = res[i];
			}else {
				idx = binarySearch(0, length, res[i]);
				v[idx] = res[i];
			}
		}
		System.out.println(length);
		br.close();
	}
	//이분 탐색https://velog.io/@kimdukbae/%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89-%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-Binary-Search
	static int binarySearch(int left, int right, int key) {
		int mid =0;
		while(left<right) {
			mid = (left+right)/2;
			if(v[mid] < key) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return right;
	}
}
