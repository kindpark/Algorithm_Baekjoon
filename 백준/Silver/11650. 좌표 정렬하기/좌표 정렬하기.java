
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int pos[][] = new int[N][2];
		for(int i = 0; i < N; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}
		Arrays.sort(pos, (y1, y2)->{
			if(y1[0] == y2[0]) {
				return y1[1] - y2[1];
			}
			else {
				return y1[0] - y2[0];
			}
		});
		for(int i = 0; i < N; i++) {
			System.out.println(pos[i][0] +" "+pos[i][1]);
		}
	}
}
