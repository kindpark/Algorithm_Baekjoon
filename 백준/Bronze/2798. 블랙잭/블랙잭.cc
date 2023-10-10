#include <stdio.h> 
#include <stdlib.h> 
int main(void) { 
    int N, M, i, j, z, answer = 0, sum; 
    int * card;
    scanf("%d %d", &N, &M); 
    card = (int*) calloc(N, sizeof(int)); 
    for(i = 0; i < N; i++)
        scanf("%d", &card[i]);
    for(i = 0; i < N; i++) { 
        for(j = i + 1; j < N; j++) { 
            for(z = j + 1; z < N; z++) { 
                sum = card[i] + card[j] + card[z]; 
                if(sum > answer && sum <= M) 
                    answer = sum; 
            } 
        } 
    }
    printf("%d", answer); 
    free(card); 
    return 0;
}

