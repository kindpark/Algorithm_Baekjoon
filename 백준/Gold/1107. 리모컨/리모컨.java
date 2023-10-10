import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] button = new boolean[10];
		int now = 100;
		// 고장난 버튼 판별
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		
		int num = N;
		while(num > -1) {
			String S = String.valueOf(num);
			boolean check = true;
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < button.length; j++) {
					if(S.charAt(i) - '0' == j) {
						if(button[j]) {
							check = false;
						}
						break;
					}
				}
				if(!check) {
					break;
				}
			}
			if(check) {
				break;
			}
			num--;
		}
		int num2 = N;
		while(num2 <= 1000000) {
			String S = String.valueOf(num2);
			boolean check = true;
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < 10; j++) {
					if(S.charAt(i) - '0' == j) {
						if(button[j]) {
							check = false;
						}
						break;
					}
				}
				if(!check) {
					break;
				}
			}
			if(check) {
				break;
			}
			num2++;
		}
		if(num < 0) {
			num = 1000000;
		}
		else {
			num = (N - num) + String.valueOf(num).length();
		}
		num2 = (num2 - N) + String.valueOf(num2).length();
		
		int result = Math.min(Math.abs(now - N), Math.min(num, num2));
		System.out.println(result);
	}

}