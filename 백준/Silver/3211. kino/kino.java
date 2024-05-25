import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] request = new int[n];
		int[] r = new int[n];
		for(int i = 0; i < n; i++) {
			request[i] = sc.nextInt();
		}
		Arrays.sort(request);
		int invite = 1;
		while(invite <= n && request[invite-1] + 1 > invite) {
			invite = request[invite-1] + 1;
		}
		System.out.println(invite);
		sc.close();
	}
}
