import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String voca = sc.next();
		int[] alphabet = new int[26];
		for(int i = 0; i < voca.length(); i++) {
			if(voca.charAt(i) == 'a' || voca.charAt(i) == 'A') {
				alphabet[0]++;
			}
			if(voca.charAt(i) == 'b' || voca.charAt(i) == 'B') {
				alphabet[1]++;
			}
			if(voca.charAt(i) == 'c' || voca.charAt(i) == 'C') {
				alphabet[2]++;
			}
			if(voca.charAt(i) == 'd' || voca.charAt(i) == 'D') {
				alphabet[3]++;
			}
			if(voca.charAt(i) == 'e' || voca.charAt(i) == 'E') {
				alphabet[4]++;
			}
			if(voca.charAt(i) == 'f' || voca.charAt(i) == 'F') {
				alphabet[5]++;
			}
			if(voca.charAt(i) == 'g' || voca.charAt(i) == 'G') {
				alphabet[6]++;
			}
			if(voca.charAt(i) == 'h' || voca.charAt(i) == 'H') {
				alphabet[7]++;
			}
			if(voca.charAt(i) == 'i' || voca.charAt(i) == 'I') {
				alphabet[8]++;
			}
			if(voca.charAt(i) == 'j' || voca.charAt(i) == 'J') {
				alphabet[9]++;
			}
			if(voca.charAt(i) == 'k' || voca.charAt(i) == 'K') {
				alphabet[10]++;
			}
			if(voca.charAt(i) == 'l' || voca.charAt(i) == 'L') {
				alphabet[11]++;
			}
			if(voca.charAt(i) == 'm' || voca.charAt(i) == 'M') {
				alphabet[12]++;
			}
			if(voca.charAt(i) == 'n' || voca.charAt(i) == 'N') {
				alphabet[13]++;
			}
			if(voca.charAt(i) == 'o' || voca.charAt(i) == 'O') {
				alphabet[14]++;
			}
			if(voca.charAt(i) == 'p' || voca.charAt(i) == 'P') {
				alphabet[15]++;
			}
			if(voca.charAt(i) == 'q' || voca.charAt(i) == 'Q') {
				alphabet[16]++;
			}
			if(voca.charAt(i) == 'r' || voca.charAt(i) == 'R') {
				alphabet[17]++;
			}
			if(voca.charAt(i) == 's' || voca.charAt(i) == 'S') {
				alphabet[18]++;
			}
			if(voca.charAt(i) == 't' || voca.charAt(i) == 'T') {
				alphabet[19]++;
			}
			if(voca.charAt(i) == 'u' || voca.charAt(i) == 'U') {
				alphabet[20]++;
			}
			if(voca.charAt(i) == 'v' || voca.charAt(i) == 'V') {
				alphabet[21]++;
			}
			if(voca.charAt(i) == 'w' || voca.charAt(i) == 'W') {
				alphabet[22]++;
			}
			if(voca.charAt(i) == 'x' || voca.charAt(i) == 'X') {
				alphabet[23]++;
			}
			if(voca.charAt(i) == 'y' || voca.charAt(i) == 'Y') {
				alphabet[24]++;
			}
			if(voca.charAt(i) == 'z' || voca.charAt(i) == 'Z') {
				alphabet[25]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		char a = 0;
		int equal = 0;
		int ans = 0;
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > 0) {
				if(alphabet[i] == ans) {
					equal = 1;
					if(ans < alphabet[i]) {
						equal = 0;
						a = (char)('A' + i);
					}
				}
				if(alphabet[i] > ans) {
					ans = alphabet[i];
					equal = 0;
					a = (char)('A' + i);
				}
			}
		}
		if(equal > 0) {
			System.out.println("?");
		}
		else {
			System.out.println(a);
		}
	}
}