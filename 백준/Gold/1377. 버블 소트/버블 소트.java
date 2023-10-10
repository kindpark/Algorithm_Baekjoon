import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
         //포인트 클래스에 인덱스(번호)와 숫자를 넣는다.
        sort[] sort = new sort[N + 1];
        //조건에서 1부터 시작하므로 1부터 N까지
        for (int i = 1; i <= N; i++) {
            sort[i] = new sort(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(sort, 1, N + 1); 
 
        int max = 0;
        //몇번 움직였는가?
        for (int i = 1; i <= N; i++) { 
            // -> (이동한 횟수 - 1)번
            max = Math.max(max, sort[i].i - i);
        }
 
        bw.write((max + 1) + "\n");
        bw.close();
        br.close();
    }
}
class sort implements Comparable<sort> {
    int n;
    int i; 
    sort(int n, int i) {
        this.n = n;
        this.i = i;
    }

    @Override
    public int compareTo(sort o) {
        return n - o.n;
    }
 
}