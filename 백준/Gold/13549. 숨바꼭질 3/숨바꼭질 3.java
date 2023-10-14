import java.util.*;

public class Main{
	static int n, k, sec;
	static boolean[] visit;
	static PriorityQueue<Point1> q;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visit = new boolean[100001];
		q = new PriorityQueue<>();
		bfs(n);
		System.out.println(sec);
	}
	public static void bfs(int s) {
		q.add(new Point1(s, 0));
		while(!q.isEmpty()) {
			Point1 p = q.poll();
			visit[p.locate] = true;
			
			if(p.locate == k) {
				sec = p.depth;
				break;
			}
			if(p.locate * 2 <= 100000 && !visit[p.locate * 2]) {
				q.add(new Point1(p.locate * 2, p.depth));
			}
			if(p.locate + 1 <= 100000 && !visit[p.locate + 1]) {
				q.add(new Point1(p.locate + 1, p.depth + 1));
			}
			if(p.locate - 1 >= 0 && !visit[p.locate - 1]) {
				q.add(new Point1(p.locate - 1, p.depth +1));
			}
		}
	}
}
//우선순위 큐를 사용해야하는지 몰라서 해멘 문제
//레퍼런스를 참고하여 보충함
class Point1 implements Comparable<Point1>{
	int depth;
	int locate;
	Point1(int locate, int depth){
		this.depth = depth;
		this.locate = locate;
	}
	@Override
	public int compareTo(Point1 o) {
		// TODO Auto-generated method stub
		return depth - o.depth;
	}
}