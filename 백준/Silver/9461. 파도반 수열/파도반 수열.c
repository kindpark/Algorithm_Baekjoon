#include <stdio.h>
 
int main(void){
    int T;
    scanf("%d", &T);
 
    for(int i=0; i<T; i++){
        int N;
        scanf("%d", &N);
 
        long long int P[N+1];
        if(N<4)
            printf("%lld\n", 1);
        else{
            P[1] = 1;
            P[2] = 1;
            P[3] = 1;
            for(int j=4; j<N+1; j++){
                P[j] = P[j-3] + P[j-2];
            }
            printf("%lld\n", P[N]);
        }
    }
}
