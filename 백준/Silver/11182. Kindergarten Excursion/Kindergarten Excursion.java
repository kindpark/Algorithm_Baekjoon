import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long swaps = 0;
        long cnt1 = 0, cnt2 = 0;
        int len = s.length();
        for(int i = 0; i<len; i++){
            if(s.charAt(i) == '0'){
                swaps+=(cnt1+cnt2);
            }
            else if(s.charAt(i) == '1'){
                swaps+=cnt2;
                cnt1++;
            }
            else{
                cnt2++;
            }
        }
        System.out.println(swaps);
    }
}
