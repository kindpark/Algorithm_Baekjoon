import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			String a = br.readLine();
			if(a.length() >= m) {
				map.put(a, map.getOrDefault(a, 0)+1);
			}
		}
		list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a1, String a2) {
				if(Integer.compare(map.get(a1), map.get(a2))!= 0) {
					return Integer.compare(map.get(a2), map.get(a1));
				}
				if(a1.length() != a2.length()) {
					return a2.length()-a1.length();
				}
				return a1.compareTo(a2);
			}
		});
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}
}