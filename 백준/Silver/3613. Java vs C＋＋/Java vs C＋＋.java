import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        if (str.charAt(0) <= '_' || str.charAt(str.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }
        boolean upperCase = false;
        boolean toJava = false;
        char pre = str.charAt(0); // 이전 문자 파악
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch <= 'Z') {
                if (toJava) {
                    System.out.println("Error!");
                    return;
                } 
                upperCase = true; 
            }
            
            if (ch == '_') {
                if (upperCase || pre == '_') {
                    System.out.println("Error!");
                    return;
                }
                toJava = true;
            }
            pre = ch;
        }   
        if(toJava){
            boolean nextUpper = false; 
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (nextUpper) {
                    sb.append(String.valueOf(ch).toUpperCase()); 
                    nextUpper = false; 
                } else {
                    if (str.charAt(i) == '_') nextUpper = true; 
                    else sb.append(ch);
                }
            }
        }
        else{
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch <= 'Z') {
                    sb.append("_");
                    sb.append(String.valueOf(ch).toLowerCase());
                } else 
                	sb.append(ch);
            }            
        }
        System.out.println(sb);
    }
}