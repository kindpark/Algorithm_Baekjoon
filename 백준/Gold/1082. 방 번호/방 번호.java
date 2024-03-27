import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[] price;
	static String[] dp = new String[55];
 	static String[] Array = {"0", "1", "2", "3", "4" ,"5", "6" ,"7", "8", "9", "10"};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		price = new int[n];
		int findMoney = 51;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			findMoney = Math.min(findMoney, price[i]);
		}
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < findMoney; i++) {
			dp[i] = "X";
		}
		dfs(findMoney);
		bw.write(dp[m]);
		bw.flush();
		br.close();
		bw.close();
	}
	private static void dfs(int findMoney) {
		if(findMoney > m) {
			return;
		}
		String mx = "0";
		for(int i = n-1; i >0; i--) {
			if(findMoney < price[i]) {
				continue;
			}
			if(dp[findMoney-price[i]].charAt(0) == 'X') {
				mx = compare(mx, Array[i]);
				continue;
			}
	        String num = Array[i];
	        String zero = Array[i];
	        for(int j = 0; j < (findMoney - price[i]) / price[0]; j++){
	            zero = zero + '0';
	        }
	        for(int j = 0; j < dp[findMoney - price[i]].length(); j++){
	            num = num + dp[findMoney - price[i]].charAt(j);
	        }
	        if(findMoney == 1){
	        }
	        mx = compare(mx, compare(num,zero));
		}
		dp[findMoney] = mx;
		dfs(findMoney + 1);
	}
	public static String compare(String a, String b) {
		if(a.length() > b.length()) {
			return a;
		}
		else if(b.length() > a.length()) {
			return b;
		}
		else {
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) > b.charAt(i)) {
					return a;
				}
				else if(a.charAt(i) < b.charAt(i)){
					return b;
                }
			}
		}
		return a;
	}
}