import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
        String parent = br.readLine();
        int n = parent.length();
		for(int i = 0; i < n; i++) {
			String pattern = parent.substring(i);
			int n2 = pattern.length();
			int[] table = new int[n2];
			int idx=0;
			for(int j=1; j<n2; j++) {
				while(idx>0 && pattern.charAt(j) != pattern.charAt(idx)) {
					idx = table[idx-1];
				}
				if(pattern.charAt(j) == pattern.charAt(idx)) {
					table[j] = ++idx;
					max = Math.max(max, idx);
				}
			}
		}
        System.out.println(max);
    }
}