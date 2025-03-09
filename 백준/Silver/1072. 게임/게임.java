import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long res = 0;
        long z = (100*y) / x;
        long left = 0;
        long right = Integer.MAX_VALUE;
        long mid = 0;
        res = x;
        if( z >= 99){
            System.out.println(-1);
            return;
        }
        else{
            while(left <= right){
                mid = (left + right) / 2;
                if(100*(y+mid) / (x+mid) > z){
                    right = mid-1;
                }else if(100*(y+mid)/(x+mid) <= z){
                    left = mid + 1;
                }
            }
        }
        System.out.println(left);
        br.close();
    }
}

