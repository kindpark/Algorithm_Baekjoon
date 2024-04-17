import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();
        int[] d = new int[101];
        int[] total = new int[101];
        int s = 0, e = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 1) {
                int b = sc.nextInt();
                int q = b % m;
                v.add(q);
                total[q]++;
                e++;
                d[q]++;
                while (d[v.get(s)] >= 2) {
                    d[v.get(s)]--;
                    s++;
                }
            } else if (a == 2) {
                if (!v.isEmpty()) {
                    int w = v.get(v.size() - 1) % m;
                    v.remove(v.size() - 1);
                    total[w]--;
                    d[w]--;
                    e--;
                    if (d[w] == 0 && total[w] != 0) {
                        for (int j = s-1; j >= 0; j--) {
                            if (v.get(j) == w) {
                                for (int k = j; k <= s - 1; k++) {
                                    d[v.get(k)]++;
                                }
                                s = j;
                                break;
                            }
                        }
                    }
                }
            } else {
                int cnt = 0;
                for (int j = 0; j < m; j++) {
                    if (d[j] != 0) cnt++;
                }
                if (cnt == m) System.out.println(e - s);
                else System.out.println(-1);
            }
        }

        sc.close();
    }
}