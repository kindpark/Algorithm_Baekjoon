import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger arr[] = new BigInteger[10002];
		arr[0] = new BigInteger("0");
		arr[1] = new BigInteger("1");
		for(int i = 2; i <= 10001; i++) {
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		int n = in.nextInt();
		System.out.println(arr[n]);
	}
}