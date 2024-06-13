import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String res = "";
        String[] dna = new String[n];
        for(int i = 0; i < n; i++){
            dna[i] = br.readLine();
        }
        int min = 0;
        int max = 0;
        for(int i = 0; i < m; i++){
            int a = 0, c = 0, g = 0, t = 0;
            for(int j = 0; j < n; j++){
                if(dna[j].charAt(i) == 'A'){
                    a++;
                }
                if(dna[j].charAt(i) == 'C'){
                    c++;
                }
                if(dna[j].charAt(i) == 'G'){
                    g++;
                }
                if(dna[j].charAt(i) == 'T'){
                    t++;
                }

            }
            max = Math.max(a>c ? a:c, g>t ? g:t);

            min += (n-max);
            bw.write(Char(a, c, g, t, max));
        }

        bw.write(res+'\n');
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
    static char Char(int a, int c, int g, int t, int max){
        if(a == max){
            return 'A';
        }
        else if(c == max){
            return 'C';
        }
        else if(g == max){
            return 'G';
        }
        else{
            return 'T';
        }
    }
}
