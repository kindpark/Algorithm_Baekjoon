import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
        // f(n,k)=((f(n-1,k)+k-1)mod n)+1, with f(1,k)=1
        //https://en.wikipedia.org/wiki/Josephus_problem
		for (int i = 1; i <= n; i++) {
			ans = (ans + k - 1) % i + 1;
		}
		
		System.out.println(ans);
	}

}