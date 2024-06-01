import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static String str, bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        StringBuilder sb = new StringBuilder();
        bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            stack.add(str.charAt(i));
            if(stack.size() >= bomb.length()) {
                boolean f = false;
                for(int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        f = true;
                        break;
                    }
                }
                if(!f){
                    for(int j = 0; j < bomb.length(); j++){
                        stack.pop();
                    }
                }

            }
        }
        for(Character c : stack){
            sb.append(c);
        }
        bw.write(String.valueOf(sb.length() == 0 ? "FRULA" : sb.toString()));
        bw.flush();
        bw.close();
        br.close();
    }
}