import java.io.*;
import java.util.*;

public class Main {
    // 승패 결과: junie 승은 1, TEST 승은 -1, 무승부는 0.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 시나리오1: OP 미사용일 때의 누적 결과
        int cumA = 0, cumB = 0; 
        int scenario1Outcome = 0; // 최종 결과 (아직 결정되지 않음)
        boolean gameEnded = false;
        
        // OverPower 사용 시 얻을 수 있는 즉시 종료 결과 중 좋은 결과가 있는지 확인.
        // 1이 최우선(승리), 그 다음 0, 마지막이 -1.
        int bestOPOutcome = -2; // 초기값, 존재하지 않음.
        
        // 각 라운드를 순차적으로 처리 (입력을 배열에 저장하지 않고 한 번만 읽음)
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // round i 전 누적합
            int preA = cumA;
            int preB = cumB;
            
            // 먼저, round i에서 OverPower를 사용한 경우의 결과를 살펴봄.
            // junie는 이 라운드에서 a 대신 floor(1.5 * a)를 투입
            int opRoundPower = (int)(Math.floor(1.5 * a));
            int opA = preA + opRoundPower; // OP 사용 시 junie의 누적힘
            int opB = preB + b;            // TEST의 누적힘 (그대로 더함)
            int opOutcome = 0;
            if(opA - opB >= 50) {  
                // 한판승 조건
                opOutcome = 1;
            } else if(opA >= K || opB >= K) {
                // 누적힘이 K 이상인 경우
                if(opA >= K && opB < K) opOutcome = 1;
                else if(opB >= K && opA < K) opOutcome = -1;
                else if(opA >= K && opB >= K) opOutcome = -1;
            } else {
                // 이 라운드에서 OP 사용 후 바로 종료되지 않는다면, 이후 진행은 시나리오1과 동일하게 흐름.
                // 즉, immediate outcome은 결정되지 않음.
                opOutcome = 2; // 미종료 상태(후에 시나리오1 결과와 동일)
            }
            // 만약 즉시 종료되는 경우(opOutcome가 1 또는 -1)라면 후보 결과로 고려
            if(opOutcome == 1 || opOutcome == -1) {
                bestOPOutcome = Math.max(bestOPOutcome, opOutcome);
            }
            
            // 시나리오1: round i의 힘을 누적합에 반영 (OP 미사용)
            cumA += a;
            cumB += b;
            
            // 시나리오1 종료 조건 체크:
            // 1) 한판승 조건: junie 누적힘 - TEST 누적힘 >= 50
            if(cumA - cumB >= 50) {
                scenario1Outcome = 1;
                gameEnded = true;
            }
            // 2) 누적힘 K 이상 조건: 단 한쪽만 K 이상이면 해당 쪽 승리, 둘 다이면 junie 승리 (OP 미사용의 경우)
            else if(cumA >= K || cumB >= K) {
                if(cumA >= K && cumB < K)
                    scenario1Outcome = 1;
                else if(cumB >= K && cumA < K)
                    scenario1Outcome = -1;
                else if(cumA >= K && cumB >= K)
                    scenario1Outcome = 1;
                gameEnded = true;
            }
            
            if(gameEnded) {
                // 게임이 종료된 시점까지만 OP 사용이 유효하므로 루프 탈출
                break;
            }
        }
        // 만약 모든 라운드를 마쳤지만 종료 조건이 없었다면 무승부
        if(!gameEnded) {
            scenario1Outcome = 0;
        }
        
        // 최종 결과 결정: junie는 승리(1)를 가장 선호하고, 그 다음 무승부(0), 그 다음 패배(-1)
        int finalOutcome = scenario1Outcome;
        if(bestOPOutcome == 1) {
            finalOutcome = 1;
        } else if(bestOPOutcome == -1 && (scenario1Outcome == 0 || scenario1Outcome == -1)) {
            // OP 사용으로 즉시 패배하는 경우가 있다면, 시나리오1 결과가 나은 경우 선택
            finalOutcome = scenario1Outcome;
        }
        System.out.println(finalOutcome);
    }
}
