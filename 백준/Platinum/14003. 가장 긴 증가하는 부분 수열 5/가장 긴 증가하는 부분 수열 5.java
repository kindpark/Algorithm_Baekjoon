import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] input, index; // index[i] : input[i]가 LIS에 들어간 위치
	static ArrayList<Integer> plar;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		index = new int[N + 1];
		plar = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
        //end
		if (N==1) {
			bw.write("1\n"+input[1]);
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		plar.add(input[1]);
		index[1] = 0;
		for (int i = 2; i <= N; i++) {
			
			if ( input[i] > plar.get(plar.size() - 1)) {
				plar.add(input[i]);
				index[i] = plar.size() - 1;
			} else {
				bs(i);
			}
		}

		StringBuilder sb = new StringBuilder();
        sb.append(plar.size() + "\n");
        Stack<Integer> stack = new Stack();
        int findId = plar.size() - 1;
        for(int i = N; findId>=0 && i > 0; i--){
            if(index[i] == findId){
            	findId--;
                stack.push(input[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void bs(int id) {
		int start, end, mid;
		start = 0;
		end = plar.size() - 1;

		while (start < end) {
			mid = (start + end) / 2;
			if (plar.get(mid) >= input[id]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		plar.set(start, input[id]);
		index[id] = start;
	}
}