import java.util.*;
public class Main {
    //잘 몰라ㅓ 참고한 문제임
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack<String> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean f = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '<') {
				f = true;
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
			}
			if(!f && s.charAt(i) == ' ') {
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
				sb.append(" ");
				continue;
			}
			if(f) {
				sb.append(s.charAt(i));
			}
			else {
				st.push(String.valueOf(s.charAt(i)));
			}
			if(s.charAt(i) == '>') {
				f = false;
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb.toString());
	}
}