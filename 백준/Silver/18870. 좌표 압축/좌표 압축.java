import java.util.Arrays;
import java.util.HashMap;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int c = 0;
		String[] p =str.split(" ");
		int arr[] = new int[num];
		int g[] = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(p[i]);
		}
		g = arr.clone();
		Arrays.sort(arr);
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(!hashmap.containsKey(arr[i])) {
				hashmap.put(arr[i], c++);
			}
		}
		for(int i = 0; i < arr.length; i++) {
			bw.write(String.valueOf(hashmap.get(g[i])) + " ");
		}
		bw.flush();
	}
}