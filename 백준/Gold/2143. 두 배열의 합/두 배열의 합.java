import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static int n, m;
	static int[] A, B;
	static List<Integer> listA = new ArrayList<>();
	static List<Integer> listB = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());
		A = new int[n];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(sarr[i]);

		m = Integer.parseInt(br.readLine());
		B = new int[m];
		sarr = br.readLine().split(" ");
		for (int i = 0; i < m; i++)
			B[i] = Integer.parseInt(sarr[i]);

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}

		Collections.sort(listA);
		Collections.sort(listB);

		bw.write(getCount() + "\n");
		bw.flush();

	}

	public static long getCount() {

		int pa = 0;
		int pb = listB.size() - 1;
		long cnt = 0;

		while (pa < listA.size() && pb >= 0) {

			long sum = listA.get(pa) + listB.get(pb);

			if (sum == T) {

				int a = listA.get(pa);
				int b = listB.get(pb);
				long aCnt = 0;
				long bCnt = 0;

				while (pa < listA.size() && listA.get(pa) == a) {
					aCnt++;
					pa++;
				}
				while (pb >= 0 && listB.get(pb) == b) {
					bCnt++;
					pb--;
				}

				cnt += aCnt * bCnt;
			}

			else if (sum < T)
				pa++;

			else if (sum > T)
				pb--;
		}

		return cnt;

	}
}