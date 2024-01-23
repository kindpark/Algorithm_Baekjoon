import java.util.*;
public class Main {
	public static void main(String[] args) {
		int n = 10001;
		int[] arr = new int[n+1];
		int[] nn;
		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
		for(int i = 0; i < n; i++) {
			if(i > 9) {
				String num = String.valueOf(i);
				nn = new int[num.length()];
				int sum = 0;
				for(int j = 0; j < num.length(); j++) {
					nn[j] = Integer.parseInt(String.valueOf(num.charAt(j)));
					sum += nn[j];
				}
				
				for(int j = 0; j < num.length(); j++) {
					for(int k = 0; k < n; k++) {
						if(sum + i == arr[k]) {
							arr[k] = 0;
						}
					}
				}
			}
			else {
				arr[i+i] = 0;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(arr[i] != 0) System.out.println(arr[i]);
		}
		
	}
}