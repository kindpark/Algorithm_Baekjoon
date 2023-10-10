import java.util.*;
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
PriorityQueue<Long> pq = new PriorityQueue<Long>();
for (int i=0; i<n; i++) {
pq.add(sc.nextLong());
		}
long num = 0;
//우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
while (pq.size() > 1) {
long temp1 = pq.poll();
long temp2 = pq.poll();
num += temp1 + temp2;
pq.add(temp1 + temp2); //합한 묶음 다시 넣기
		}
System.out.println(num);
}
}
	