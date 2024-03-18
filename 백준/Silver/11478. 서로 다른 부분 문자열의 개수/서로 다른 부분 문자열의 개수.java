import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		TreeSet<String> ts = new TreeSet<>();
		String s = sc.nextLine();
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j <= s.length(); j++) {
				ts.add(s.substring(i, j));
			}
		}
		System.out.println(ts.size()-1);
	}
}