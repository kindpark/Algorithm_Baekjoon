import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
 
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 배열의 크기
 
            sb.append(((N + 1) / 2) + "\n"); // 중앙값의 개수 출력
            ArrayList<Integer> a = new ArrayList<>();
            int cnt = 0; // 줄 간격 띄우기 위한 용도
 
            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
 
                int x = Integer.parseInt(st.nextToken());
                a.add(x);
                Collections.sort(a); // 입력받을 때마다 오름차순 정렬.
                
                // 인덱스는 0부터 시작하므로 짝수 번째 인덱스를 탐색할 때마다
                // 중앙값을 출력하면 됨.
                if (i % 2 == 0) {
                    // 한 줄의 최대 10개만 가능.
                    if (cnt == 9 || i == N - 1) {
                        sb.append(a.get(i / 2) + "\n");
                        cnt = 0;
                    } else {
                        sb.append(a.get(i / 2) + " ");
                    }
                    cnt++;
                }
            }
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}
