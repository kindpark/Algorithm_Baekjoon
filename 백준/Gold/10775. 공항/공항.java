import java.util.*;
public class Main {
	static int[] gate;
	static int[] gt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		int p = sc.nextInt();
		gate = new int[g+1];
		gt = new int[g+1];
		for(int i = 1; i <= g; i++) {
			gate[i] = i;
			gt[i] = 1;
		}
		int res = 0;
		int ga;
		int dit;
		while(p-- > 0) {
			ga = sc.nextInt();
			dit = find(ga);
			if(dit != 0) {
			    
				merge(dit, dit-1);
				res++;
			}
			else {
				break;
			}
		}
		System.out.println(res);
	}
	public static int find(int x) {
		if(x == gate[x]) return x;
		return gate[x] = find(gate[x]); 
	}
	public static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		gate[x] = y;
	}
}