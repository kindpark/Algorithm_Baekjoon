import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int result = A * B * C;
		String a = Integer.toString(result);
		int[] number = new int[10];
		for(int i = 0; i < 10; i++) {
			number[i] = 0;
		}
		for(int i = 0; i < a.length(); i++) {
			char s = a.charAt(i);
			if(s == '0') {
				number[0]++;
			}
			if(s == '1') {
				number[1]++;
			}
			if(s == '2') {
				number[2]++;
			}
			if(s == '3') {
				number[3]++;
			}
			if(s == '4') {
				number[4]++;
			}
			if(s == '5') {
				number[5]++;
			}
			if(s == '6') {
				number[6]++;
			}
			if(s == '7') {
				number[7]++;
			}
			if(s == '8') {
				number[8]++;
			}
			if(s == '9') {
				number[9]++;
			}
		}
		
		for(int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
	}
}
