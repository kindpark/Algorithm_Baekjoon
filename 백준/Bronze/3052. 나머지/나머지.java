import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		A a = new A();
		int s = 10;
		int k = 10;
		int count = 0;
		int[] arr = new int[k];
		int[] na = new int[k];
		for(int i = 0; i < k; i++) {
			arr[i] = in.nextInt();
		}
		na = a.a(arr);
		for(int i = 0; i < 10; i++) {
			for(int j = i; j<10; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = arr[i];
				}
			}
		}
		Arrays.sort(na);
		for(int i = 0; i < 9; i++) {
			if(na[i] != na[i+1]) {
				count++;
			}
		}
        count++;
		System.out.println(count);
	}
}
class A{
	public int[] a(int arr[]) {
		int[] na = new int[10];
		for(int i = 0; i < 10; i++) {
			na[i] = (arr[i] % 42);
		}
		return na;
	}
}
