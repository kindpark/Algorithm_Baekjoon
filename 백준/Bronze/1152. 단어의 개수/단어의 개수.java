import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		in.close();
		
		StringTokenizer st = new StringTokenizer(a, " ");
		System.out.println(st.countTokens());
	}
}