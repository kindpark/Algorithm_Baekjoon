
import java.io.*;
import java.util.*;
public class Main{
	static int N;	//행렬 크기
	static int MOD = 1000;	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.valueOf(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0;j<N;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
        	}
        }
        int[][] result = arrPow(arr, B);
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		bw.write(result[i][j] + " ");
        	}
        	bw.newLine();
        }
        bw.flush();	//결과 출력
        bw.close();
        br.close();
    }
    //제곱
    public static int[][] arrPow(int[][] A, long size) {
    	if(size==1)
    		return A;
    	
    	int[][] temp = arrPow(A, size/2);
    	
    	if(size%2==0) {
    		return arrMul(temp,temp);
    	}else {
    		return arrMul(arrMul(temp, temp), A);
    	}
    }
    //곱셈
    public static int[][] arrMul(int[][] A, int[][] B){
    	int[][] temp = new int[N][N];
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			for(int k=0;k<N;k++) {
    				temp[i][j] += A[i][k] * B[k][j];
    				temp[i][j] %= MOD;
    			}
    		}
    	}
    	return temp;
    	
    }
}