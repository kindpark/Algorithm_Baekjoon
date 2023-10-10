import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[2];
		String in = br.readLine();
		StringTokenizer st = new StringTokenizer(in);
		input[0] = Integer.parseInt(st.nextToken());//입력
		input[1] = Integer.parseInt(st.nextToken());//찾기
		HashMap<String, String> h = new HashMap<String, String>();
		for(int i = 0; i < input[0]; i++) {
			in = br.readLine();
			st = new StringTokenizer(in);
			h.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i < input[1]; i++) {
			in = br.readLine();
			System.out.println(h.get(in));
		}
	}
}