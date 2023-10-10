import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		temp[] t = new temp[N];
		for(int i = 0; i < N; i++) {
			t[i] = new temp(in.nextInt(), in.next());
		}
		Arrays.sort(t, new Comparator<temp>(){
			@Override
			public int compare(temp t1, temp t2) {
				return t1.old-t2.old;
			}
		});
		for(int i = 0; i < N; i++) {
			System.out.println(t[i].old +" "+t[i].name);
		}
	}
}
class temp{
	String name;
	int old;
	public temp(int old, String name) {
		this.name = name;
		this.old = old;
	}
}