
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MaxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			for(int j = 0; j < arr.length; j++) {
				MaxHeap.add(Integer.parseInt(arr[j]));
			}
		}
		for(int i = 0; i < n-1; i++) {
			MaxHeap.poll();
		}
		System.out.println(MaxHeap.poll());
		
	}
}
