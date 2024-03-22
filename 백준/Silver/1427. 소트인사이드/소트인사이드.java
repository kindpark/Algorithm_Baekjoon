import java.util.*;
public class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        Integer[] r = new Integer[s.length];
        for(int i = 0; i < s.length; i++) {
        	r[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(r, Collections.reverseOrder());
        for(int i = 0; i < r.length; i++) {
        	System.out.print(r[i]);
        }
    }
}