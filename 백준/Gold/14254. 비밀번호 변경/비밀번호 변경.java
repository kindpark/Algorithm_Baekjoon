import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        int res = 0;
        int n = Integer.parseInt(br.readLine());
        String rest = a.substring(a.length()-n);
        String prefix = a.substring(0, n);
        if(a.length()/2 >= n){
            for(int i = 0; i < n; i++){
                if(prefix.charAt(i) != rest.charAt(i)){
                    res++;
                }
            }
        }else{
            HashMap<Character, Integer>cnt;
            int k = a.length() - n;
            for(int i = 0; i < k; i++){
                int p = i;
                cnt = new HashMap<>();
                while(p < a.length()){
                    cnt.put(a.charAt(p), cnt.getOrDefault(a.charAt(p), 0) + 1);
                    p+= k;
                }
                char m = findMax(cnt);
                for(char key : cnt.keySet()){
                    if(key == m){
                        continue;
                    }
                    res+=cnt.get(key);
                }
            }
        }
        System.out.println(res);
    }
    static char findMax(HashMap<Character, Integer> cnt){
        int mx = -1;
        char mxkey = ' ';
        for(char key : cnt.keySet()){
            if(cnt.get(key) > mx){
                mx = cnt.get(key);
                mxkey = key;
            }
        }
        return mxkey;
    }
}