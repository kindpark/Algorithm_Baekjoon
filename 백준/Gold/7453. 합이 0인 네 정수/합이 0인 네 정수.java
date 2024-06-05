import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[] a, b, c, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        long cnt = 0;
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        Arrays.sort(d);
        int left = 0;
        int right = n-1;
        int index = 0;
        int[] cdSum = new int[n*n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cdSum[index++] = c[i] + d[j];
            }
        }
        Arrays.sort(cdSum);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int absum = a[i] + b[j];
                int leftside = leftSide(-absum, cdSum);
                int rightside = rightSide(-absum, cdSum);
                cnt+=Math.abs(leftside-rightside);
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    //a와 b의 합이 몇개인지 찾는다.
    public static int leftSide(int idx, int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] > idx){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
    public static int rightSide(int idx, int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] >= idx){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
}