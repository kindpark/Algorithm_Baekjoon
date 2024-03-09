
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] n = sc.nextLine().split(" ");
		int[] dd1 = new int[3];
		int[] dd2 = new int[3];
		long sum1 = 0, sum2 = 0;
		for(int i = 0; i < 3; i++) {
			dd1[i] = Integer.parseInt(n[i]);
		}
		n = sc.nextLine().split(" ");
		for(int i = 0; i < 3; i++) {
			dd2[i] = Integer.parseInt(n[i]);
		}
		for(int i = 1; i < dd1[0]; i++) {
			if(i % 4 == 0) {
				if(i % 100 == 0) {
					if(i % 400 == 0) {
						sum1 += 366;
					}
					else {
						sum1 += 365;
					}
				}
				else {
					sum1 += 366;
				}
			}
			else {
				sum1 += 365;
			}
		}
		for(int i = 1; i < dd2[0]; i++) {
			if(i % 4 == 0) {
				if(i % 100 == 0) {
					if(i % 400 == 0) {
						sum2 += 366;
					}
					else {
						sum2 += 365;
					}
				}
				else {
					sum2 += 366;
				}
			}

			else {
				sum2 += 365;
			}
		}
		for(int i = 1; i < dd1[1]; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i== 12) {
				sum1 += 31;
			}
			else if(i == 2) {
				if(dd1[0] % 4 == 0) {
					if(dd1[0] % 100 == 0) {
						if(dd1[0] % 400 == 0) {
							sum1 += 29;
						}
						else {
							sum1 += 28;
						}
					}
					else {
						sum1 += 29;
					}
				}
				else {
					sum1 += 28;
				}
			}
			else {
				sum1 += 30;
			}
		}
		for(int i = 1; i < dd2[1]; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i== 12) {
				sum2 += 31;
			}
			else if(i == 2) {
				if(dd2[0] % 4 == 0) {
					if(dd2[0] % 100 == 0) {
						if(dd2[0] % 400 == 0) {
							sum2 += 29;
						}
						else {
							sum2 += 28;
						}
					}
					else {
						sum2 += 29;
					}
				}
				else {
					sum2 += 28;
				}
			}
			else {
				sum2 += 30;
			}
		}
		sum1 += dd1[2];
		sum2 += dd2[2];
		if(dd2[0] - dd1[0] > 1000 || dd2[0] - dd1[0] == 1000 && (dd1[1] <= dd2[1]  && dd1[2] <= dd2[2])){
			System.out.println("gg");
		}
		else
			System.out.println("D-" + (sum2-sum1));
	}
}