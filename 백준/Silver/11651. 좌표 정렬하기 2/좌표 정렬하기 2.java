import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int pos[][] = new int[n][2];
		for(int i = 0; i < n; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}
		Arrays.sort(pos, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				else {
					return o1[1] - o2[1];
				}
			}
			
		});
		for(int i = 0; i < n; i++) {
			System.out.println(pos[i][0] + " " + pos[i][1]);
		}
	}
}