import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 1;
		int left = 1;
		int right = 1;
		int sum = 1;
		while(left != n) {
			if(sum < n) {
				right++;
				sum += right;
			}
			else if(sum > n) {
				sum -= left;
				left++;
			}
			else{
				cnt++;
				right++;
				sum += right;
			}
		}
		System.out.println(cnt);
	}
}
