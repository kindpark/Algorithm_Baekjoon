#include <stdio.h>
 
void solve(int count, int N, int add, int sub, int mult, int div, int value);
 
//global variables
int max = -1000000000;
int min = 1000000000;
int num[11];
 
int main(void){
    int N;
    int operators[4];
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        scanf("%d", &num[i]);
    }
    for(int i=0; i<4; i++){
        scanf("%d", &operators[i]);
    }
 
    solve(0, N, operators[0], operators[1], operators[2], operators[3], num[0]);
    printf("%d\n", max);
    printf("%d\n", min);
}
 
void solve(int count, int N, int add, int sub, int mult, int div, int value){
    if(count==N-1){
        if(value>max)
            max = value;
        if(value<min)
            min = value;
    }
    else{
        if(add!=0){
            solve(count+1, N, add-1, sub, mult, div, value + num[count+1]);
        }
        if(sub!=0){
            solve(count+1, N, add, sub-1, mult, div, value - num[count+1]);
        }
        if(mult!=0){
            solve(count+1, N, add, sub, mult-1, div, value * num[count+1]);
        }
        if(num[count+1]!=0 && div!=0){
            solve(count+1, N, add, sub, mult, div-1, value / num[count+1]);
        }
    }
}