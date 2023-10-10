//소스 참고 : https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int page = in.nextInt();
	    int[] ans = new int[10];
	    int point = 1;
	    int start = 1;
	 
	    while (start <= page) {
	        // 끝자리 9로 만들기
	        while (page % 10 != 9 && start <= page) {
	            ntonine(page, ans, point);
	            page--;
	        }
	 
	        if (page < start) {
	            break;
	        }
	 
	        // 끝자리 0으로 만들기
	        while (start % 10 != 0 && start <= page) {
	            ntonine(start, ans, point);
	            start++;
	        }
	 
	        start /= 10;
	        page /= 10;
	 
	        for (int i = 0; i < 10; i++) {
	            ans[i] += (page - start + 1) * point;
	        }
	 
	        point *= 10;
	    }
	 
	    for (int i = 0; i < 10; i++) {
	        System.out.print(ans[i] + " ");
	    }
	}
	public static void ntonine(int x, int[] ans, int point) {
		while (x > 0) {
			ans[x % 10] += point;
			x /= 10;
		} 
	}
}