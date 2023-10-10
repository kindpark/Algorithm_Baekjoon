import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		int s = 100;
		Integer[] pizza = new Integer[n];
		int a = 0;
		for(int i = 0; i < n; i++) {
			
			String p = sc.next();
			int piece = 0;
			if(p.equals("1/2")) {
				piece = 50;
			}
			else if(p.equals("1/4")) {
				piece = 25;
			}
			else if(p.equals("3/4")) {
				piece = 75;
			}
			pizza[i] = piece;
		}
		Arrays.sort(pizza, Collections.reverseOrder());
		List<Integer> leave = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(s >= pizza[i]) {
				s -= pizza[i];
			}
			else {
				int rr = i;
				leave.add(s);
				if(leave.stream().filter(x -> x >= pizza[rr]).count() > 0) {
					for(int j = 0; j < leave.size(); j++) {
						if(leave.get(j) >= pizza[i]) {
							leave.remove(j);
							break;
						}
					}
				}
				else {
					a++;
					s = 100 - pizza[i];
				}
			}
		}
		System.out.println(a+1);
	}
}
