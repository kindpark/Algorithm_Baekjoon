import java.util.Scanner;

public class Main{
	int getsum(int x1,int y1, int x2, int y2, int cx, int cy, int r) {
		int a1 = (int)(Math.pow(x1-cx, 2)+Math.pow(y1-cy, 2));
		int a2 = (int)(Math.pow(x2-cx, 2)+Math.pow(y2-cy, 2));
		int radius = (int)Math.pow(r, 2);
		if ((a1<radius && a2>radius) || (a1>radius && a2<radius)) { //행성을 진입할 때와 빠져나올 때이다. 
			return 1;
		} else {
			return 0;
		}
	}
	public static void main(String[] args) {
		Main main = new Main();
		int t; 
		int x1,x2,y1,y2; 
		int n; 
		int cx,cy,r; 
		
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		
		int arr[] = new int[t];
		
		for (int i = 0; i <t; i++) {
			x1 = in.nextInt(); 
			y1 = in.nextInt();
			x2 = in.nextInt();
			y2 = in.nextInt();
			
			n = in.nextInt();
			
			for (int j = 0; j < n; j++) {
				cx = in.nextInt();
				cy = in.nextInt();
				r=in.nextInt();
				
				arr[i] += main.getsum(x1, y1, x2, y2, cx, cy, r);
			}
		}
		for (int i = 0; i < t; i++) {
			System.out.println(arr[i]);
		}
    }
}