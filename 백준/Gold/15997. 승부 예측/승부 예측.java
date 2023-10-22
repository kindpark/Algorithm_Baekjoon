import java.io.*;
import java.util.*;

public class Main {

    static double rate[][] = new double[6][3];
    static String twoNations[][] = new String[6][2];
    static HashMap<String, Integer> nationIndex = new HashMap<>();
    static double answer[] = new double[4];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nations = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < 4; i++) {
            nationIndex.put(nations.nextToken(), i);
            answer[i] = 0;
        }

        for(int i = 0; i < 6; i++) {
            StringTokenizer data = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j< 2; j++) twoNations[i][j] = data.nextToken();
            for(int j = 0; j < 3; j++) rate[i][j] = strToDouble(data.nextToken());
        }

        int score[] = new int[4];
        for(int j = 0; j < 3; j++) {
            dfs(0, j, 1, score.clone());
        }

        for(int i = 0; i < 4; i++) System.out.println(answer[i]);
    }
    public static void dfs(int y, int x, double percent, int score[]) {
        // 확률이 0%인 경우 return
        if(rate[y][x] == 0) return;

        if(x == 0) score[nationIndex.get(twoNations[y][0])] += 3;
        else if(x == 1) {
            score[nationIndex.get(twoNations[y][0])] += 1;
            score[nationIndex.get(twoNations[y][1])] += 1;
        } else score[nationIndex.get(twoNations[y][1])] += 3;
        percent = percent * rate[y][x];

        if(y == 5) {
            int sorted[] = score.clone(), first = 0, second = 0;
            Arrays.sort(sorted);
            for(int i = 0; i < 4; i++) {
                if(sorted[3] == sorted[i]) first++;
                if(sorted[2] == sorted[i]) second++;
            }
            double firstRate = 1;
            if(first >= 2) firstRate = 2.0 / first;

            for(int i = 0; i < 4; i++) {
                if (sorted[3] == score[i]) answer[i] = percent * firstRate + answer[i];
                if (first == 1) if(sorted[2] == score[i]) answer[i] = percent / second + answer[i];
            }
            return;
        }

        // win, draw, lose를 탐색하기 위한 for
        for(int j = 0; j < 3; j++) dfs(y + 1, j, percent, score.clone());
    }

    private static double strToDouble(String str) {
        return Double.parseDouble(str);
    }
}