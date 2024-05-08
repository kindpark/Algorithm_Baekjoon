import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> dq = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] command = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		int card = 1;
		for(int i = n-1; i >= 0; i--) {
			if(command[i] == 1) {
				dq.addLast(card);
			}
			if(command[i] == 2) {
				int temp = dq.getLast();
				dq.pollLast();
				dq.addLast(card);
				dq.addLast(temp);
			}
			if(command[i] == 3) {
				dq.addFirst(card);
			}
			card++;
		}
		for(int i = n-1; i >= 0; i--) {
			list.add(dq.poll());
		}
		for(int i = n-1; i>=0; i--) {
			bw.write(list.get(i) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}