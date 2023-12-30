import java.util.*;
import java.io.*;
public class Main {
	static StringBuilder sb;
	static String[] s = new String[61];
	static int n= 0, cnt = 0;
    static int to=3, from=1, by=2;
    static long k;
	public static void main(String[] args) throws IOException{
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextLong();
		long pw = (long) Math.pow(2, n-1);
        long pwm = pw / 2;
        while(true){
            if(k == pw){
                System.out.println(from + " " +to);
                break;
            }
            else if(k < pw){
                cnt = to;
                to = by;
                by = cnt;
                pw -= pwm;
            }
            else if(k > pw){
                cnt = from;
                from = by;
                by = cnt;
                pw += pwm;
            }
            pwm /=2;
        }
	}
    static long pow(int x){
        long result = 1;
        for(int i = 0; i < x; i++){
            result *= 2;
        }
        return result;
    }
}