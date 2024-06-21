import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int clap = 0;
        int n = sc.nextInt();
        //ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++){
            int b = sc.nextInt();
            arr[b] = i;
        }
        for(int i = 1; i < n; i++){
            //if(list.get(i) < list.get(i-1)){
           if(arr[i] > arr[i+1]){
                clap++;
            }
        }

        System.out.println(clap);
    }
}