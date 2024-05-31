import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> cp = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
			cp.add(arr.get(i));
			hm.put(arr.get(i), hm.getOrDefault(arr.get(i), 0)+1);
		}
		//빈도 많은게 뒤에 오도록 설정
		Collections.sort(arr, (l1, l2) ->{
			if(hm.get(l1) == hm.get(l2)) {
				return cp.indexOf(l1) - cp.indexOf(l2);
			}
			else {
				return Integer.compare(hm.get(l2), hm.get(l1));
			}
		});
		for(int i = 0; i < n; i++) {
			bw.write(arr.get(i) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
