import java.io.*;
import java.util.Arrays;

class Point1 implements Comparable<Point1> {
    int num; // 숫자
    int idx; // 인덱스
    Point1(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
    @Override
    public int compareTo(Point1 o) {
        return num - o.num;
    }
}
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        String[] p = br.readLine().split(" ");
        Point1[] points = new Point1[n + 1];
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(p[i-1]);
            points[i] = new Point1(temp, i);
        }
        Arrays.sort(points, 1, n + 1); // [1, n)
 
        int max = 0;
        for (int i = 1; i <= n; i++) { // 해당 숫자의 인덱스가 몇 칸 움직였는지 계산
            max = Math.max(max, points[i].idx - i); // -> (이동한 횟수 - 1)번
        }
        bw.write((max) + "\n"); // 위에서 구한 값은 (이동한 횟수 - 1)번이므로 1 더함.
        bw.close();
        br.close();
    }
 
}