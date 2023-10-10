import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		loop: for(int i = 0 ; i < T ; i++) {
			boolean re = true;
			int N;
			LinkedList<Integer> q = new LinkedList<>();
			char[] function;	
			function = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			while(st.hasMoreTokens())
				q.add(Integer.parseInt(st.nextToken()));
			for(char ch : function) {
				if(ch == 'R') {
					re = !re;
					continue;
				}
				if(q.isEmpty()) {
					sb.append("error").append("\n");
					continue loop;
				} else {
					if(re == true)
						q.pollFirst();
					else
						q.pollLast();
					}
			}
			 if(re == true && !q.isEmpty()) {
				sb.append("[" + q.pollFirst());
				while(!q.isEmpty()) {
					sb.append("," + q.pollFirst());
				}
				sb.append("]").append("\n");
				
			}else if(re==false && !q.isEmpty()){
				sb.append("[" + q.pollLast());
				while(!q.isEmpty()) {
					sb.append("," + q.pollLast());
				}
				sb.append("]").append("\n");
			}else {
				sb.append("[]").append("\n");
			}
		}
		System.out.println(sb);
	}
	
}