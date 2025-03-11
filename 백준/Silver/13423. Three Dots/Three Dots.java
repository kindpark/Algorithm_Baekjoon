import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] s = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(s);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 2; j < n; j++) {
                    if (binarySearch(i, j, s)) {
                        ans++;
                    }
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static boolean binarySearch(int start, int end, int[] s) {
        if ((s[start] + s[end]) % 2 != 0) return false;
        int target = (s[start] + s[end]) / 2;
        int left = start, right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (s[mid] == target) return true;
            else if (s[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
