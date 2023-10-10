import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[n+1];
        int index = 0; // index는 현재 부분수열의 가장 큰 값의 index를 가리 킴

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (answer[index] < num) { // num이 현재 가장 긴 부분수열의 최대값보다 크면, index를 하나 늘려주고 그 자리에 num을 추가함
                answer[++index] = num;
            } else { // num이 부분수열의 최대값보다 같거나 작으면, 알맞은 자리를 이진 탐색을 통해 찾아줌
                int lowerbound = findLowerBound(num, answer, index);
                answer[lowerbound] = num;
            }
        }
        System.out.println(index);
    }

    static int findLowerBound(int num, int[] answer, int size) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) / 2;
            if (answer[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}