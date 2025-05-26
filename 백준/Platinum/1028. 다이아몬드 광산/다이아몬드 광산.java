import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r+1][c+1];
        dp = new int[r+1][c+1][4];

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j< c; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        if(r == 1 && c == 1){
            System.out.println(map[0][0]);
            return;
        }
        int mx= 0;
        for(int i = 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(map[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        dp[i][j][k] = getDp(i,j,k);
                    }
                    //위로 올라가야하는데 위로 못올라가는 상황이라면?
                    if(dp[i][j][0] > mx && dp[i][j][1] > mx){
                        int len = Math.min(dp[i][j][0], dp[i][j][1])-1;
                        //다이아몬드 모양이 되는지 확인(몰랐던 부분)
                        for(int l = len; l >=mx; l--){
                            if(i-(2*l)<0) continue;
                            //아랫변의 길이가 최댓값을 초과하는가?(몰랐던 부분)
                            if(dp[i-(2*l)][j][2] > l && dp[i-(2*l)][j][3] > l){
                                mx = l+1;
                                break;
                            }
                        }
                    }

                }
            }
        }
        System.out.println(mx);

    }
    //다이아 크기, 방향 판별
    public static int getDp(int i, int j, int k){
        int size = 0;
        int dx = 0;
        int dy = 0;
        while(true) {
            int xx = dx + i;
            int yy = dy + j;
            //상왼
            if (k == 0) {
                dx--;
                dy--;
            }
            //상오
            else if (k == 1) {
                dx--;
                dy++;
            }
            //하왼
            else if (k == 2) {
                dx++;
                dy--;
            }
            //하오
            else if (k == 3) {
                dx++;
                dy++;
            }

            if (xx < 0 || yy < 0 || xx >= r || yy >= c || map[xx][yy] == 0)
                break;
            size++;
        }
        return size;
    }

}
