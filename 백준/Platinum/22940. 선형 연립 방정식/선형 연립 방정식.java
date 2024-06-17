import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double[][] equation = new double[n][n+1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= n; j++){
                equation[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            double d = equation[i][i];
            for(int j = i; j <= n; j++){
                equation[i][j] /= d;
            }
            for(int j = 0; j <n; j++){
                if(i==j){
                    continue;
                }
                double a= -equation[j][i];
                for(int k = 0; k <= n; k++) {
                    equation[j][k]  += equation[i][k] * a;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.printf("%.0f ", equation[i][n]);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}