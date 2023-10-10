
#include <stdio.h>
#include <string.h> 

int number[100001];
int count = 0;
//push X: 정수 X를 스택에 넣는 연산
void push(int num) {
	number[count] = num;
	count++;
}
//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
void pop() {
	if (count != 0) {
		count--;
		printf("%d\n", number[count]);
		number[count] = 0;
	}
	//만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다
	else
		printf("%d\n", -1);

}
//top: 스택의 가장 위에 있는 정수를 출력
void top() {
	if (count != 0)
		printf("%d\n", number[count - 1]);
	//스택에 들어있는 정수가 없는 경우에는 - 1
	else
		printf("%d\n", -1);
}
//size: 스택에 들어있는 정수의 개수를 출력
void size() {
	printf("%d\n", count);
}
void empty() {
	//empty: 스택이 비어있으면 1
	if (count != 0) {
		printf("0\n");
	}
	//아니면 0을 출력
	else {
		printf("1\n");
	}
}
int main() {
	int n;//첫째 줄에 주어지는 명령의 수 N
	char stack[10];//입력한 문자 넣는 배열 생성

	scanf("%d", &n); //명령의 수 입력 받기
	
	int number[100]; //입력한 숫자의 stack 배열 생성

	for (int i = 0; i < n; i++) {
		scanf("%s", &stack);
		if (strcmp(stack, "push") == 0) {
			int num;//문자 이후에 포함되어 있는 숫자
			scanf("%d", &num);
			push(num);
		}
		else if (strcmp(stack, "pop") == 0) {
			pop();
		}
		else if (strcmp(stack, "top") == 0) {
			top();
		}
		else if (strcmp(stack, "size") == 0) {
			size();
		}
		else if (strcmp(stack, "empty") == 0) {
			empty();
		}
	}
}