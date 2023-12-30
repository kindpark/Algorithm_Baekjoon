import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[1001];
		int count = 0;
		for(int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		for(int i = 2; i <= n; i++) {
			if(arr[i] == 0) {
				continue;
			}
			else {
				for(int j = i; j <= n; j+= i) {
					if(arr[j] != 0) {
						arr[j] = 0;
						count++;
					}
					if(count == m) {
						System.out.println(j);
						break;
					}
				}
			}
		}
	}
}