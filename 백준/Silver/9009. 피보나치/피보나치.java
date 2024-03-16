import java.util.*;
public class Main {
	public static void main(String[] args) {
		int[] fibo = new int[10000000];
		fibo[1] = 1;
		fibo[2] = 1;
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		for(int k = 0; k < c; k++) {
			StringBuilder sb = null;
			int a = sc.nextInt();
			int fl = 0;
			for(int i = 3; i < fibo.length; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
				if(fibo[i] > a) {
					fl = i;
					break;
				}
			}
			int sum = 0;
			Stack<Integer> stack = new Stack<>();
			while(a != sum) {
				sb = new StringBuilder();
				sum = 0;
				for(int i = fl-1; i >= 1; i--) {
					if(fibo[i] + sum <= a ) {
						sum += fibo[i];
						stack.add(fibo[i]);
					}
				}
			}
			int s = stack.size();
			for(int i = s-1; i>= 0; i--) {
				sb.append(stack.pop() + " ");
			}
			System.out.println(sb.toString());
		}
	}
}