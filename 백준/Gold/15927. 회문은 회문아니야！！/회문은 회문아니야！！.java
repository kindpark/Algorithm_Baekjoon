import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int length = s.length();
        int p = 0;
        for(int i = 0; i < length/2; i++){
            if(s.charAt(i) != s.charAt(length-i-1)){
                System.out.println(s.length());
                return;
            }
            else if(s.charAt(i) != s.charAt(i+1)){
                p = 1;
            }
        }
        if(p==1){
            System.out.println(s.length()-1);
        }
        else{
            System.out.println(-1);
        }
    }
}