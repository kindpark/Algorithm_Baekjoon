import java.util.*;
import java.io.*;
//배열로 했더니 시간초과가 될 것 같았고, 간과되는게 있는거 같아 연결리스트로 수정해서 맞춤

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n;
        while(t-->0){
            int res = 1;
            n = Integer.parseInt(br.readLine());
            ArrayList<Apply> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Apply(a, b));
            }
            Collections.sort(list);
            int mnscore = list.get(0).interview;
            for(int i = 1; i < n; i++) {
                if (list.get(i).interview < mnscore) {
                    res++;
                    mnscore = list.get(i).interview;
                }
            }
            bw.write(String.valueOf(res) + "\n");

        }
        bw.flush();
        bw.close();

    }
    static class Apply implements Comparable<Apply>{
        int sheet;
        int interview;
        Apply(int sheet, int interview){
            this.sheet = sheet;
            this.interview = interview;
        }

        @Override
        public int compareTo(Apply o) {
            if(this.sheet > o.sheet){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}