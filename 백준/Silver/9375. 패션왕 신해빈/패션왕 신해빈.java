import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		try(
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			){
			HashMap<String, Integer> hm;
			StringTokenizer st;
			String cloth;
			int t = Integer.parseInt(br.readLine());
			for(int k = 0; k < t; k++) {
				int n = Integer.parseInt(br.readLine());
				hm = new HashMap<>();
				for(int i = 0; i < n; i++) {
					st = new StringTokenizer(br.readLine());
					st.nextToken();
					cloth = st.nextToken();
					if(hm.containsKey(cloth)) {
						hm.put(cloth, hm.get(cloth)+1);
					}
					else {
						hm.put(cloth, 1);
					}
				}
				int res = 1;
				//옷을 입지 않는 경우 고려해야함
				//ex)선글라스만
				for(int i : hm.values()) {
					res *= (i+1);
				}
				//알몸 제외
				bw.write(String.valueOf(res - 1)+'\n');
			}
			bw.flush();
		}	
	}
	
}