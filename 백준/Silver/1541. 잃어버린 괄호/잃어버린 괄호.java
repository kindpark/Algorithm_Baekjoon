import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //-분리
		String[] s = sc.nextLine().split("-");
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < s.length; i++) {
			int temp = 0;
            //+붙은거 분리
			String[] a = s[i].split("\\+");
			for(int j = 0; j < a.length; j++) {
				temp += Integer.parseInt(a[j]);
			}
            //어느 수도 안집어넣어져있으면 집어넣고
			if(res == Integer.MAX_VALUE) res = temp;
			//-를 통해 분리한것대로 다 빼준다.
            else res -= temp;
		}
		System.out.println(res);
		sc.close();
	}
}
