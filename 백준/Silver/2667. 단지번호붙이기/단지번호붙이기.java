import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
	static int[][] matrix;//맵
	static boolean[][] check;
	static int[] aparts = new int[25*25];
	static int apn = 0;
	static Queue<Integer>q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		matrix = new int[n+1][n+1];
		check = new boolean[n+1][n+1];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] arr = s.split("");
			for(int j = 0; j <n; j++) {
				matrix[i][j] = Integer.parseInt(arr[j]);
			}
		}
		for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1 && !check[i][j]){
                    apn++;
                    dfs(i,j);
                }
            }
        }
		Arrays.sort(aparts);
        System.out.println(apn);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            	continue;
            }else{               
                System.out.println(aparts[i]);
            }
        }
	}
	public static void dfs(int x, int y) {
        check[x][y] = true;
        aparts[apn]++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < n && ny < n){
                if(matrix[nx][ny] == 1 && !check[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}