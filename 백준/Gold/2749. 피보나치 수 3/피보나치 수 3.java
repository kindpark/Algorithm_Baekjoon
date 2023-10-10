import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//피사노정리 제대로 숙지할것.
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int pisano = 1500000;
		long N = Long.parseLong(br.readLine()) % pisano;
		long arr[] = new long[pisano + 1];
		arr[0] = 0;
		if(N > 0) {
			arr[1] = 1;
		}
		for(int i = 2; i <= pisano; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000;
		}
		System.out.println(arr[(int)N]);
	}
}
