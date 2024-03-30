import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			hm.put(Integer.parseInt(st.nextToken()), i);
		}		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = hm.get(Integer.parseInt(st.nextToken()));
		}
		LinkedList<Integer> list = new LinkedList<>();
		for(int i : arr) {
			if(list.isEmpty()) {
				list.add(i);
			}
			else if(list.getLast() < i) {
				list.add(i);
			}
			else {
                //맞는것 끼리 이진 탐색
				int a = -Collections.binarySearch(list, i)-1;
				list.set(a, i);
			}
		}
		bw.write(String.valueOf(list.size()));
		bw.flush();
		bw.close();
		br.close();
	}
}