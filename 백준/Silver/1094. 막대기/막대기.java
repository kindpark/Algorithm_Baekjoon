import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		LinkedList<Integer> stick = new LinkedList<>();
		int sum = 0;
		int res = 0;
		for(int i = 64; i >= 1; i/=2) {
			stick.add(i);
		}
		//Collections.sort(stick);
		for(int i = 0; i < stick.size(); i++) {
			if(sum + stick.get(i)<= x) {
				sum += stick.get(i);
				res++;
			}
			else {
				continue;
			}
		}
		System.out.println(res);
	}
}
