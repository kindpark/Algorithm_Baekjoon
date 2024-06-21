import java.io.*;
public class Main {
    static int n, cnt, mx;
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());;
        String st;
        while(t-->0){
            cnt=0;
            mx = 0;
            n = Integer.parseInt(br.readLine());
            arr = new char[n+1][n+1];
            for(int i = 0; i < n; i++){
                st = br.readLine();
                for(int j = 0; j < n; j++){
                    arr[i][j] = st.charAt(j);
                }
            }
            if(b() == 1)
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == '.'){
                        cnt = isSquare(i, j);
                        mx = cnt > mx ? cnt : mx;
                    }
                }
            }
            else mx = n;
            sb.append(mx + "\n");
        }
        System.out.println(sb.toString());
    }
    static int b() {
        int f = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '#') f = 1;
            }
        }
        return f;
    }
    public static int isSquare(int x, int y){
        for(int i = 1; i <= n; i++){
            if(bo(i, x, y)){
                continue;
            }
            else{
                return i-1;
            }
        }
        return 1;
    }
    public static boolean bo(int s, int x, int y){
        for(int i = x; i < x+s; i++){
           for(int j =y; j < y+s; j++) {
               if(i >= n || j >= n){
                   return false;
               }
               if(arr[i][j] == '#'){
                   return false;
               }
           }
        }
        return true;
    }
}
