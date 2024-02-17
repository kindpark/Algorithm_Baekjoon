import java.util.*;
public class Main{
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String p = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<Integer>();
		KMP(t, p);

		System.out.println(list.size());
		for (int l : list) {
			sb.append(l + " ");
		}

		System.out.println(sb.toString());
	}

	public static void KMP(String o, String p) {
		int[] pt = new int[p.length()];
		int a = 0;
		for (int i = 1; i < p.length(); i++) {
			while (a > 0 && p.charAt(i) != p.charAt(a)) {
				a = pt[a - 1];
			}
			if (p.charAt(i) == p.charAt(a))
				pt[i] = ++a;
		}
		int j = 0;
		for (int i = 0; i < o.length(); i++) {
			while (j > 0 && o.charAt(i) != p.charAt(j)) {
				j = pt[j - 1];
			}
			if (o.charAt(i) == p.charAt(j)) {
				if (j + 1 == p.length()) {
					list.add(i - p.length() + 2);
					j = pt[j];
				} else {
					j++;
				}
			}
		}
	}
}