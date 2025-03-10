import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //삭제는 결국 재귀밖에 안떠오름
        //dp로도 될 것 같은데 귀찮네요
        int left = 0, right=0, del = 0;
        String s = "";
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            s = br.readLine();
            int result = pallindrome(0, s.length()-1, 0, s);
            bw.write(String.valueOf(result) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int pallindrome(int left, int right, int del, String s){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                if(del == 0){
                    //차례로 대응되는 글자가 있는지 조사
                    if(pallindrome(left+1, right, 1, s)== 0 || pallindrome(left, right-1, 1, s) == 0){
                        return 1;
                    }
                    return 2;
                }
                else{
                    return 2;
                }
            }else{
                left++;
                right--;
            }
        }
        return 0;
    }
}

