import java.io.*;

import java.util.StringTokenizer;

 

public class Main {

 

    public static void main(String[] args) throws Exception {

        BufferedReader br = 

                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = 

                new BufferedWriter(new OutputStreamWriter(System.out));



 

        StringTokenizer st = new StringTokenizer(br.readLine());

 

        long min = Long.parseLong(st.nextToken());

        long max = Long.parseLong(st.nextToken());

 

 

        int result = (int) (max - min) + 1;

 

        boolean[] check = new boolean[result];

 

        for (long i = 2; i * i <= max; i++) {

            long squared = i * i; 

            long start = min % squared == 0 ? min / 

                        squared : (min / squared) + 1;    


        

 

            for (long j = start; squared * j <= max; j++) {

                check[(int) ((j * squared) - min)] = true;


                

       

            } 

 

        }
        int count = 0;

        

        for (int i = 0; i <= max - min; i++) {

            if (!check[i])

                count++;

        }

        bw.write(count + "\n");

 

        bw.flush();

        br.close();

        bw.close();

 

    }

}
//[참고] 자바 문제 6) 제곱 ㄴㄴ 수 - BAEKJOON 1016|작성자 repid2