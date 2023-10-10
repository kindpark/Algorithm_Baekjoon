import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main test =new Main();
    }

    public Main() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk ;

        ArrayList<Integer> datas = new ArrayList<>();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < tc ; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int a = 0;
            String command = stk.nextToken();

            if(stk.hasMoreTokens()){
                a = Integer.parseInt(stk.nextToken());
            }
            solution(command,a,datas);
        }
    }


    public void solution (String command ,int a,ArrayList<Integer> datas){



        if(command.equals("push")){
            datas.add(0,a);
            return;
        }else if(command.equals("pop")){
            if(datas.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(datas.get(datas.size()-1));
                datas.remove(datas.size()-1);
            }
            return;

        }else if(command.equals("size")){
            System.out.println(datas.size());
            return;

        }else if(command.equals("empty")){
            if (datas.isEmpty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            return;

        }else if(command.equals("front")){
            if (datas.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(datas.get(datas.size()-1));
            }
            return;

        }else if(command.equals("back")){
            if (datas.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(datas.get(0));
            }
        }
    }

}