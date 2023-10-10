import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[10001];
		int p = 1;
		int n = Integer.parseInt(br.readLine());
		for(int i = 666; i< Integer.MAX_VALUE; i++) {
			if(p > 10000) {
				break;
			}
			String a= String.valueOf(i);
			if(a.contains("666")) {
				arr[p++] = Integer.parseInt(a);
			}
		}
		bw.write(String.valueOf(arr[n]));
		bw.flush();
	}
}