#include <stdio.h>

#define True 1

#define False 0

typedef struct _stack{

    int arr[100000];

    int topindex;

}stack;

 

typedef stack Stack;

 

void Stackinit(Stack *pstack){

    pstack->topindex = -1;

}

 

void Push(Stack *pstack,char data){

 

    pstack->topindex = pstack->topindex + 1;

    pstack->arr[pstack->topindex] = data;

 

}

 

int return_top(Stack *pstack){ //스택의 topindex값을 반환하는 함수

    return pstack->topindex;

}  

 

void change_topindex(Stack *pstack, int data){

    pstack->topindex = data; //스택의 topindex값 바꾸는 함수

}

int main(void){

    int array[100000];

    int sum = 1; //막대의 제일 오른쪽에 있는 것을 포함해서 초기값을 1이라 설정함

    Stack stack;

    Stackinit(&stack); //스택의 초기화

    int n;

    scanf("%d",&n);

    for(int i = 0;i<n;i++){

        int x;

        scanf("%d",&array[i]);  

        Push(&stack,array[i]);  //막대를 스택에 생성한다

    }

    for(int i = return_top(&stack);i>=0;i--){  //스택의 topindex(오른쪽)부터 처음 막대(왼쪽)까지 참조

        if(array[i]>array[return_top(&stack)]){ 

            sum = sum + 1;                      //배열의 막대 길이가 topindex막대 (제일 오른쪽에 있는 막대)보다 길다면 sum + 1을 한다

            change_topindex(&stack,i);          //또한 topindex의 값을 바꿔준다

        }

    }

    printf("%d",sum);

 

}