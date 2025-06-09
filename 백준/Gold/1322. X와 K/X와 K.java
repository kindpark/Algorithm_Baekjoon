import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        List<Long> bit = new ArrayList<>();
        long cur = 1;
        while((1L << bit.size())<=k){
            if((x|cur) != x){
                bit.add(cur);
            }
            cur <<=1;
        }
        long res = 0;
        for(int i = bit.size() - 1; i>=0; i--){
            if(k==0) break;
            long pw = 1 << i;
            if(k>=pw){
                res += bit.get(i);
                k-=pw;
            }
        }
        System.out.println(res);
    }
}