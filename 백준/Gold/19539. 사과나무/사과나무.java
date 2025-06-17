import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tree;
        int sum = 0;
        //2 물뿌리개 사용 횟수
        int w2Cnt = 0;
        for(int i = 0; i < n; i++){
            tree = Integer.parseInt(st.nextToken());
            sum += tree;
            
            w2Cnt += tree/2;
        }
        if(sum %3 != 0){
            System.out.println("NO");
        }else {
            //2물뿌리개 사용 횟수가 전체 걸리는 날보다 같다면? 
            //1도 2와 같이 사용했으므로 무조건 3의 배수
            if (w2Cnt >= sum / 3) {
                System.out.println("YES");
                //크다면 2중의 몇은 1을 두번 사용해서 3배수 만들수 있어서 가능
            } else {
                System.out.println("NO");
            }
        }
    }
}