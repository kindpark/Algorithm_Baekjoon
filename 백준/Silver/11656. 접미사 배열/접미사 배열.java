import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		//String[] suffix = new String[s.length()+1];
		TreeSet<String> suffix = new TreeSet<>();
		for(int i = 0; i < s.length(); i++) {
			suffix.add(s.substring(i, s.length()));
		}
		Iterator iter = suffix.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
