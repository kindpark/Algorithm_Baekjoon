import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        boolean[] check = new boolean[10000002];
        int res = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        //1 1 2 3 6 7 30
        //1
        int sum = 1;
        check[weight[0]] = true;
        for(int i = 0; i < weight.length; i++){
            if(weight[i] > sum)break;
            for(int j = 0; j < sum; j++){
                if(check[j]) check[weight[i] + j] = true;
            }
            check[weight[i]] = true;
            sum += weight[i];
        }
        while (res < check.length && check[res]) {
            res++;
        }
        System.out.println(res);
    }
}