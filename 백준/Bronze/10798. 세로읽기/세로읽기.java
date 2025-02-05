import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] str = new char[5][15];
        for(int i = 0; i < 5; i++)
            Arrays.fill(str[i], '.');

        for(int i = 0; i < 5; i++){
            String s = br.readLine();
            char[] st = s.toCharArray();
            for(int j = 0; j < st.length; j++){
                str[i][j] = st[j];
            }
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(str[j][i] != '.')
                    bw.write(str[j][i]);
            }
        }
        bw.flush();
    }
}

