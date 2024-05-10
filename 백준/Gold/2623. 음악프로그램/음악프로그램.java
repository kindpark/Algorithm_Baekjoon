import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] num = new int[n+1];
		ArrayList<Integer> list[] = new ArrayList[n+1];
		ArrayList<Integer> v = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int singNum = Integer.parseInt(st.nextToken());
			int singer = 0;
			int n0 = Integer.parseInt(st.nextToken());
			for(int i = 1; i < singNum; i++) {
				singer = Integer.parseInt(st.nextToken());
				list[n0].add(singer);
				num[singer]++;
				n0 = singer;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
            if (num[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            v.add(x);

            for (int i = 0; i < list[x].size(); i++) {
                int nx = list[x].get(i);
                num[nx]--;
                if (num[nx] == 0)
                    q.add(nx);
            }
        }
        if(v.size() == n) {
        	for(int i : v) {
        		bw.write(i + "\n");
        	}
        }else {
        	bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}
