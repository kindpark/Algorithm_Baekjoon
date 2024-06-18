import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        //1이면 A가 먼저 지우므로 A가 패배
        //2 1 2 무조건 B 승리
        //3 1 2 3
        //4 1 2 3 4
        //5 1 2 3 4 5
        //무조건 홀수번만 돌게 되므로 A가 패배
        //맞는지모르겠음..
        bw.write(a == 1 ? "B" : "A");
        bw.flush();
        bw.close();
        br.close();
    }
}
