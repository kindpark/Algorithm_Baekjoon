import java.util.*;
import java.io.*;
public class Main {
	static class P{
		long x;
		long y;
		P(long x, long y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int p = 1;
		st = new StringTokenizer(br.readLine());
		P x1 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		P y1 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		P x2 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		P y2 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		bw.write(String.valueOf(isIntersect(x1, y1, x2, y2)));
		bw.flush();
		bw.close();
		br.close();
	}
	static long ccw(P p1, P p2, P p3) {
		long s = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
		s -= (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
		if(s > 0) return 1;
		if(s == 0) return 0;
		else return -1;
 	}
	static int isIntersect(P x1, P y1, P x2, P y2) {
		boolean r = false;
		int res = 0;
		long p123 = ccw(x1, y1, x2);
		long p124 = ccw(x1, y1, y2); // l1 기준
		long p341 = ccw(x2, y2, x1);
		long p342 = ccw(x2, y2, y1); // l2 기준

		boolean xtox1 = Math.min(x1.x, y1.x) <= Math.max(x2.x, y2.x);
		boolean xtox2 = Math.min(x2.x, y2.x) <= Math.max(x1.x, y1.x);
		boolean ytoy1 = Math.min(x1.y, y1.y) <= Math.max(x2.y, y2.y);
		boolean ytoy2 = Math.min(x2.y, y2.y) <= Math.max(x1.y, y1.y);
		if(p123 * p124 == 0 && p341 * p342 == 0) {
			r = true;
			if(xtox1 && xtox2 && ytoy1 && ytoy2) {
				res = 1;
			}
		}
		if(p123 * p124 <= 0 && p341 * p342 <= 0) {
			if(!r) {
				res = 1;
			}
		}
		return res;
	}
}
