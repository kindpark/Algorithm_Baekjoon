import java.util.*;

public class Main{
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while(tc-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>();
			for(int i= 0; i < n; i++) {
				int s = in.nextInt();
				q.offer(new int[] {i, s});
			}
			int c = 0;
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean max = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수
				// 큐에 남아있는 원소들과 중요도를 비교 
				for(int i = 0; i < q.size(); i++) {
					
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
					if(front[1] < q.get(i)[1]) {
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						max = false;
						break;
					}
				}
				if(max == false) {
					continue;
				}
				c++;
				if(front[0] == m) {
					break;
				}
			}
		sb.append(c).append('\n');
		}
		System.out.println(sb);
	}
}