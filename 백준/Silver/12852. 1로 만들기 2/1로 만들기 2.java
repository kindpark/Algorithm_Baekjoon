import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
       
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] memo = new int[n+1];
		arr[0] = 0;
		arr[1] = 0;
		for(int i = 2; i <= n; i++){
			arr[i] = arr[i-1] + 1;
			if(i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i/2] + 1);
			}
			if(i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i/3] + 1);
			}
			
		}
		System.out.println(arr[n]);
		while(true) {
			sb.append(n + " ");
			if(n == 1) {
				break;
			}
            //메모라이징 해둔거 되짚어보기
			if(n % 2 == 0 && arr[n] - 1 == arr[n/2]) {
				n /= 2;
			}
			else if(n % 3 == 0 && arr[n] - 1 == arr[n/3]) {
				n /= 3;
			}
			else {
				n--;
			}
		}
		System.out.println(sb.toString());
	}
}