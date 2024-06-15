import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[n];
        HashSet<Character> hs = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <n; i++){
            arr[i]=st.nextToken();
        }
        for(char i = 'A'; i <= 'Z'; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[j].charAt(0) == i){
                    cnt++;
                }
            }
            if(cnt == 1){
                for(int j = 0; j < n; j++){
                    if(arr[j].charAt(0) != i){
                        hs.add((char)Math.max(i, arr[j].charAt(1)));
                    }
                }
            }
            else if(cnt >1){
                for(int j = 0; j < n; j++)
                    hs.add((char)Math.max(i, arr[j].charAt(1)));
            }
        }
        System.out.println(hs.size());

        for(Character s : hs){
            list.add(s);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)+" ");
        }
        System.out.println(sb.toString());
    }
}
