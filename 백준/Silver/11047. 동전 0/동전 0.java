import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int kind = in.nextInt();
		int have = in.nextInt();
		boolean a = true;
		int count = 0;
		int s = 0;
		Integer[] money = new Integer[kind]; 
		for(int i = 0; i < kind; i++) {
			money[i] = in.nextInt();
		}
		Arrays.sort(money, Collections.reverseOrder());
		for(int i = 0; i < kind; i++) {
			if(have>=money[i]) {
				count += (have/money[i]);
				have = (have%money[i]);
			}
		}
        System.out.println(count);
	}
}
