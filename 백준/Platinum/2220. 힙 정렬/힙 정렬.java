import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//1은 무조건 끝으로 보내야함
		//힙 구성
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[1] = 1;
		for(int i = 2; i <= n; i++) {
			arr[i] = i;
			//1은 결국 맨 끝으로
			arr = swap(i-1, i, arr);
			//최대 힙
			//3 1 2 1 2 3 
			//결국 가장 큰게 위로 감
			for(int j = i-1; j > 1; j/=2) {
				arr = swap(j, j/2, arr);
			}
		}
		for(int i = 1; i <= n; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int[] swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
}

