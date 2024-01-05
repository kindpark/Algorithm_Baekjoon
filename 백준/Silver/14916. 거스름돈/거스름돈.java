import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
        //그리디잘하고싶다
		while(true) {
			if(n%5 == 0 && n != 0) {
				cnt++;
				n = n-5;
			}
			else if(n /2 >= 1) {
				cnt++;
				n = n-2;
			}
			else if(n != 0) {
				System.out.println(-1);
				break;
			}
			else {
				System.out.println(cnt);
				break;
			}
		}
	}
}