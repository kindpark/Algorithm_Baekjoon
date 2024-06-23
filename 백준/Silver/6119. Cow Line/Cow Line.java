import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq= new LinkedList<>();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n = 1;
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.equals("A")){
                if(b.equals("L")){
                    dq.addFirst(n);
                    n++;
                }
                else{
                    dq.addLast(n);
                    n++;
                }
            }
            else if(a.equals("D")){
                int c = Integer.parseInt(st.nextToken());
                if(b.equals("L")){
                    for(int j = 0; j < c; j++){
                        dq.pollFirst();
                    }
                }
                else{
                    for(int j = 0; j < c; j++){
                        dq.pollLast();
                    }
                }
            }
        }   
        int k = dq.size();
        for(int i = 0; i < k; i++){
            bw.write(String.valueOf(dq.pollFirst())+'\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
