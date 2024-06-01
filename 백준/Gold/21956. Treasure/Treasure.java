import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static String str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int c = 0;
            if(!stack.isEmpty() && stack.peek().ch == str.charAt(i)){
                stack.peek().cnt++;
                if(stack.peek().cnt == k){
                    stack.pop();
                }
            }
            else{
                stack.add(new Pair(str.charAt(i), 1));
            }
        }
        for(Pair p : stack){
            for(int i = 0; i < p.cnt; i++) {
                sb.append(String.valueOf(p.ch));
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static class Pair{
        char ch;
        int cnt;
        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}