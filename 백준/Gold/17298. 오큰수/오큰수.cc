#include <stdio.h>
#include <stdlib.h>


typedef struct Stack{
    int arr[1000001];
    int size;
}Stack;

int empty(Stack *s){
    return s->size==0;
}

int top(Stack *s){
    return s->arr[s->size-1];
}

void push(Stack *s, int num){
    s->arr[s->size++]=num;
}

int pop(Stack *s){
    return s->arr[--s->size];
}

int main(void){
    Stack* stack = (Stack *)malloc(sizeof(Stack));
    int N;
    scanf("%d",&N);
    int arr[N];
    int ans[N];
    for(int i=0;i<N;i++)
    {
        scanf("%d", &arr[i]);
        ans[i]=-1;
    }

    for(int i=0;i<N;i++)
    {
        while(!empty(stack) && arr[top(stack)] < arr[i])
            ans[pop(stack)] = arr[i];

        push(stack, i);
    }

    for(int i=0;i<N;i++)
        printf("%d ", ans[i]);

    return 0;
    //내가 푼거 아님
    //출처https://coding-doomchicken.tistory.com/45
}