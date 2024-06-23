import java.util.*;
import java.io.*;
public class Main {
    static int x, y;
    static int[] histogram;
    static int high, hhigh;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t=-1,w=-1;
        double sum = 0;
        while(true){
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(t==0 && w == 0){
                break;
            }
            sum = 0.0;
            high = 0;
            hhigh = 0;
            histogram = new int[11];
            for(int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                histogram[x/w]++;
            }
            for(int i = 0; i < 11; i++){
                if(histogram[i]>0){
                    hhigh = i;
                }
                high = Math.max(histogram[i], high);
            }
            for(int i = 0; i <= hhigh; i++){
                sum += cal(i, histogram[i]);
            }
            sum += 0.01;
            System.out.printf("%.5f\n", sum);
        }
        br.close();
    }
    static double cal(int w, int h){
        double a = ((double)hhigh - w) / hhigh;
        double b = ((double) h) /high;
        return a*b;
    }
}