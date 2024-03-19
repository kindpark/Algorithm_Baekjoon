import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int mid = 0;
		int[] animal = new int[n];
		for(int i = 0; i < n; i++) {
			animal[i] = sc.nextInt();
		}
		
		Arrays.sort(animal);
		int start = 1;
		int end = animal[n-1];
		while(start <= end) {
			mid = (start + end)/2;
			if(snack(mid, animal)>= m) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
	public static int snack(int mid, int[] animal) {
		int cnt = 0;
		for(int i : animal) {
			cnt += i / mid;
		}
		return cnt;
	}
}