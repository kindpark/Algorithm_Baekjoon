import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 0; //비교값
		int N = sc.nextInt();//도시 수
		long cost = 0;//최소 비용
		long[] length = new long[N-1];//도시간 거리
		for(int i = 0; i < N-1; i++) {
			length[i] = sc.nextInt();
		}
		long[] cityoilcost = new long[N];//도시의 오일 비용
		for(int i = 0; i < N; i++) {
			cityoilcost[i] = sc.nextInt();
		}
		cost+= (cityoilcost[0] * length[0]);
		for(int i = 1; i < N-1; i++) {
			if(cityoilcost[k] <= cityoilcost[i]) {
				cityoilcost[i] = cityoilcost[k];
				cost+= (cityoilcost[i] * length[i]);
			}
			if(cityoilcost[k]>cityoilcost[i]) {
				cost += (cityoilcost[i] * length[i]);
				k=i;
			}
		}
		System.out.println(cost);
	}
}
