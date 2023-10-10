import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int n = Integer.parseInt(br.readLine());
	      int sum = 0;
	      int sub = 0;

	      int max = 0;
	      int min = 0;
	      String[] arr = br.readLine().replaceAll("2", "-1").split(" ");

	      for (int i = 0; i < n; i++) {
	         sum = Math.max(sum, 0) + Integer.parseInt(arr[i]);
	         sub = Math.min(sub, 0) + Integer.parseInt(arr[i]);

	         max = Math.max(sum, max);
	         min = Math.min(sub, min);
	      }

	      max = Math.max(max, Math.abs(min));

	      System.out.println(max);
	  }
}