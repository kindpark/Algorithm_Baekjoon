import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int res = 0;
        st = new StringTokenizer(br.readLine());
        //0으로 들러서 새로운 책을 뽑는 불상사를 없에는 것이 조금 더 효율이기에 양수와 음수를 2분할 함
        PriorityQueue<Integer> positivePlace = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        PriorityQueue<Integer> negativePlace = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a > 0){
                positivePlace.add(a);
            }else{
                negativePlace.add(Math.abs(a));
            }
        }
        if(positivePlace.isEmpty()){
           max = negativePlace.peek();
        }else if(negativePlace.isEmpty()){
            max = positivePlace.peek();
        }else{
            max = Math.max(positivePlace.peek(), negativePlace.peek());
        }
        while(!positivePlace.isEmpty()){
            int a = positivePlace.poll();
            for(int i = 0; i < m-1; i++){
                positivePlace.poll();
                if(positivePlace.isEmpty()){
                    break;
                }
            }
            res += a*2;
        }
        while(!negativePlace.isEmpty()){
            int a = negativePlace.poll();
            for(int i = 0; i < m-1; i++){
                negativePlace.poll();
                if(negativePlace.isEmpty()){
                    break;
                }
            }
            res += a*2;
        }
        //마지막으로 가게 될 가장 먼 거리에서 안 돌아와도 되므로 빼야함
        res -= max;
        System.out.println(res);
    }
}