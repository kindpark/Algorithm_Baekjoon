import java.util.*;
import java.io.*;

public class Main {
	static long mod = (long) 1e12;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		long[] f = new long[n+1];
		long num;
		f[1] = 1;
		for(int i = 2; i <= n; i++) {
			f[i] = f[i-1] * i;
			while(f[i] % 10 == 0) {
				f[i] /= 10;
			}
			f[i] %= mod;
		}
		num = f[n] % 100000;
		//if()
		System.out.printf("%05d",num);
	}
}