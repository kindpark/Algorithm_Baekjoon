import java.io.*;
import java.util.*;
public class Main{
	static int n,m;
	static int[][] num,dp;	//N×N수 저장 배열, 누적합 저장 배열
	public static void main(String[] arg) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + num[i][j];	//누적합 저장
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = cal(x1,y1,x2,y2);
			bw.write(result + "\n");	
		}
		bw.flush();		//결과 출력
		bw.close();
		br.close();
	}
    	//행의 누적합을 이용하여 구간의 합을 구하는 함수
	static int cal(int x1, int y1, int x2, int y2) {
		int sum = 0;
		if(x1 == x2)		//동일한 행일때
			sum = dp[x2][y2] - dp[x1][y1-1];
		else {
        		//동일한 행이 아니면 구간마다 합을 구하는 함수 작성
			for(int i=x1;i<=x2;i++)
				sum += dp[i][y2] - dp[i][y1-1];
		}
		return sum;		//구간의 합 반환
	}
}