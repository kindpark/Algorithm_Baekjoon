import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int X = 13;
		int Y;
		int number = 1;
		int[][] arr = new int[X][];
		int[][] numberArray = new int[X][];
		for(int i = 1; i < X; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i ==10 || i == 12) {
				Y = 32;
				arr[i] = new int[Y];
				numberArray[i] = new int[Y];
				for(int j = 1; j < Y; j++) {
					arr[i][j] = j;
					numberArray[i][j] = number;
					number++;
				}
			}
			if(i == 2) {
				Y = 29;
				arr[i] = new int[Y];
				numberArray[i] = new int[Y];
				for(int j = 1; j < Y; j++) {
					arr[i][j] = j;
					numberArray[i][j] = number;
					number++;
				}
			}
			if(i == 4 || i == 6 || i == 9 || i == 11){
				Y = 31;
				arr[i] = new int[Y];
				numberArray[i] = new int[Y];
				for(int j = 1; j < Y; j++) {
					arr[i][j] = j;
					numberArray[i][j] = number;
					number++;
				}
			}
		}
		int x = in.nextInt();
		int y = in.nextInt();
		if(numberArray[x][y] % 7 == 0) {
			System.out.println("SUN");
		}
		if(numberArray[x][y] % 7 == 1) {
			System.out.println("MON");
		}
		if(numberArray[x][y] % 7 == 2) {
			System.out.println("TUE");
		}
		if(numberArray[x][y] % 7 == 3) {
			System.out.println("WED");
		}
		if(numberArray[x][y] % 7 == 4) {
			System.out.println("THU");
		}
		if(numberArray[x][y] % 7 == 5) {
			System.out.println("FRI");
		}
		if(numberArray[x][y] % 7 == 6) {
			System.out.println("SAT");
		}
	
	}
}
