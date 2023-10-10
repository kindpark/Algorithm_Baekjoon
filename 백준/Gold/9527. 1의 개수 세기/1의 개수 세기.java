import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()) - 1;
        long b = Long.parseLong(st.nextToken());
        long ans = 0;
        int ja = 0, jb = 0;		//비트가 1인 자리의 개수
        for (int i = 53; i >= 0; i--) {
        	//비트 구하기.. 
        	//출처 https://dohyonne.tistory.com/2
            if ((a & (1L << i)) == (1L << i)) {		//A의 i번째 비트가 1인지 확인
                ans -= i * (1L << i - 1);
                ans -= ja * ((1L << i) - 1);
                ans -= ++ja;
            }
            if ((b & (1L << i)) == (1L << i)) {		//B의 i번째 비트가 1인지 확인
                ans += i * (1L << i - 1);
                ans += jb * ((1L << i) - 1);
                ans += ++jb;
            }
        }
        System.out.println(ans);
    }
}
