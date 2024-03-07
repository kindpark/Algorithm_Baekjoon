import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> house = new ArrayList<>();
		int r = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			house.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(house);
		r = n/2;
		if(n % 2 == 0) {
			int sum1 = 0;
			for(int i = 0; i < n; i++) {
				
				sum1 += Math.abs(house.get(r) - house.get(i));
			}
			r--;
			int sum2 = 0;
			for(int i = 0; i < n; i++) {
				sum2 += Math.abs(house.get(r) - house.get(i));
			}
			if(sum1 > sum2) {
				r++;
			}
		}
		else {
			r = n/2;
		}
		System.out.println(house.get(r));
	}
}