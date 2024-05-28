import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s, mbti;
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			if(n > 32) {
                System.out.println(0);
				continue;
			}
			mbti = new String[n];
			for(int i = 0; i < n; i++) {
				mbti[i] = st.nextToken();
			}
			int res;
			int r = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					for(int k = j+1; k<n; k++) {
						res=0;
						for(int t = 0; t < 4; t++) {
							res += mbti[i].charAt(t) != mbti[j].charAt(t) ? 1 : 0;
							res += mbti[i].charAt(t) != mbti[k].charAt(t) ? 1 : 0;
							res += mbti[j].charAt(t) != mbti[k].charAt(t) ? 1 : 0;		
						}
						r = Math.min(res, r);
						if(r==0) {
							break;
						}
					}
				}
			}
			bw.write(String.valueOf(r)+'\n');
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
