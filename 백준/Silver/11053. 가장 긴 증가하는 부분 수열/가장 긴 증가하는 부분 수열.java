import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr =new int[N+1];
        int[] dp =new int[N+1];

        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        dp[0]=1;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]&&dp[j]>=dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

        }
        br.close();
        int max=0;

        for(int i=0;i<N;i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
        System.out.println(max);
    }
}