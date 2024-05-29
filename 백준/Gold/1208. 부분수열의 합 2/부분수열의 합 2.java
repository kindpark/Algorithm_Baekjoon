import java.util.*;
import java.io.*;
public class Main{
	static int n, s, res, res1=0, res2 = 0;
	static long[] arr;
	static List<Long> left;
	static List<Long> right;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		left = new ArrayList<>();
		right = new ArrayList<>();
		divide(0, n/2, 0, left);
		divide(n/2, n, 0, right);
		Collections.sort(left);
		Collections.sort(right);
		int start = 0;
		int end = right.size()-1;
		long cnt = 0;
		while(start < left.size() && end >= 0) {
			long sum = left.get(start) + right.get(end);
			if(sum == s) {
				long a = left.get(start);
				long cnt1 = 0;
				while(start < left.size() && left.get(start) == a) {
					start++;
					cnt1++;
				}
				long b = right.get(end);
				long cnt2 = 0;
				while(end >= 0 && right.get(end) == b) {
					end--;
					cnt2++;
				}
				cnt += cnt1 * cnt2;
			}
			else if(sum < s) {
				start++;
			}
			else {
				end--;
			}
		}
		if(s == 0) {
			cnt--;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
	//배열을 분할하여 부분집합과 그 합을 계산하여 map에 저장
	//putSegmentSum은 부분집합의 합을 계산하여 map에 저장하고 재귀를 반복
	//sum은 s에서 해당 합을 뺸 값이 map에 존재하는지 확인하고 res에 더함
	static void divide(int index, int end, long sum, List<Long> list) {
		if(index == end) {
			list.add(sum);
			return;
		}
		divide(index+1, end, sum+arr[index], list);
		divide(index+1, end, sum, list);
	}
}