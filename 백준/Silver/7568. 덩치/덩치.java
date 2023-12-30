import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
 
		String[] sp;
		for(int i = 0; i < n; i++) {
			sp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(sp[0]);
			arr[i][1] = Integer.parseInt(sp[1]);
		}
		
				
		for(int i = 0; i < n; i++) {
			int rank = 1;
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			sb.append(rank + " ");
		}
        System.out.println(sb.toString());
	}
}