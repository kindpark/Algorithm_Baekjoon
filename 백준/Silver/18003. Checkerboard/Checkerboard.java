import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rc = new int[4];
        for(int i = 0; i < 4; i++){
            rc[i] = Integer.parseInt(st.nextToken());
        }
        int[] vs = new int[rc[2]];
        int[] hs = new int[rc[3]];

        for (int i = 0; i < rc[2]; i++) {
            vs[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < rc[3]; i++) {
            hs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < rc[2]; i++) {
            for (int k = 0; k < vs[i]; k++) {
                for (int j = 0; j < rc[3]; j++) {
                    for (int q = 0; q < hs[j]; q++) {
                    	if(((i+j) & 1) == 1) {
                    		System.out.print('W');
                    	}
                    	else {
                    		System.out.print('B');
                    	}
                    }
                }
                System.out.println();
            }
        }
    }
}