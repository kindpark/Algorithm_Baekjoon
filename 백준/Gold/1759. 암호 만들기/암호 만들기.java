import java.util.*;

public class Main {
	public static char[] alpabet;
	public static boolean[] visited; // 방문 여부 체크 배열
	public static int l,c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		l=sc.nextInt();
		c=sc.nextInt();
		alpabet=new char[c];
		visited=new boolean[c];
		
		for(int i=0;i<c;i++)
			alpabet[i]=sc.next().charAt(0);
		
		Arrays.sort(alpabet);
		
		dfs(0,0);
	}
	
	public static void dfs(int start, int depth) {
		if(depth==l) {
			int cons=0; 
			int vow=0; 
			StringBuilder sb=new StringBuilder();
			
			for(int i=0;i<c;i++) {
				if(visited[i]==true) {
					sb.append(alpabet[i]);
					// 모음 count
					if(alpabet[i]=='a'||alpabet[i]=='e'||alpabet[i]=='i'
							||alpabet[i]=='o'||alpabet[i]=='u')
						vow++;
					// 자음 count
					else
						cons++;
				}
			}
			// 조건에 맞다면 print
			if(vow>=1&&cons>=2)
				System.out.println(sb);
		}
		
		for(int i=start;i<c;i++) {
			visited[i]=true;
			dfs(i+1,depth+1); // 깊이를 1 늘리고 재귀호출
			// 재귀호출이 끝났다면 다음 연산을 위해 방문 배열의 값을 되돌려준다.
			visited[i]=false;
		}
	}
}