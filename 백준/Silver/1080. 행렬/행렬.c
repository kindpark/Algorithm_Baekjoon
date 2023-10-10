#include <stdio.h>
 
int arr[50][50];
 
int main() {
    int N, M;
    scanf("%d %d", &N, &M);
 

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++)
            scanf("%1d", &arr[i][j]);
    }
 
    int num;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%1d", &num);
 
            
            if (arr[i][j] != num) arr[i][j] = 1;
         
            else arr[i][j] = 0;
        }
    }
 
    //전체 크기가 3*3이 되지 않는 경우
    if (N < 3 || M < 3) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]) {
                    printf("-1\n");
                    return 0;
                }
            }
        }
        printf("0\n");
    }
    //전체 크기가 3*3보다 큰 경우
    else {
        int cnt = 0;
 
        //전체 범위 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]) {
                    //3*3 범위내라면 뒤집기
                    if (i < N - 2 && j < M - 2) {
                        
                        for (int x = i; x < i + 3; x++) {
                            for (int y = j; y < j + 3; y++) {
                                arr[x][y] = !arr[x][y];
                            }
                        }
                    
                        cnt++;
                    }
                    //범위 밖이라면 더이상 뒤집을 수 없음
                    else {
                        if (arr[i][j]) {
                            printf("-1\n");
                            return 0;
                        }
                    }
                }
            }
        }
        printf("%d\n", cnt);
    }
 
    return 0;
}
