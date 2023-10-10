
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int j;
		int k = sc.nextInt();
		int[] arr= new int[k];
		for(int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
		}
		for(int s = 0; s < k*k; s++) {
			for(int i = 1; i < k; i++) {
				if(arr[i-1] < arr[i]) {
					j = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = j;
				}
				if(arr[i-1] > arr[i]) {
					j = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = j;
				}
			}
		}
		for(int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
	}
}
