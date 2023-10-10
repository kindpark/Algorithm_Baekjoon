#include <stdio.h>
#include <string.h>

#define MAX 101

double stack[MAX];
char infix[MAX];
char postfix[MAX];

int top = -1;
int p_top = -1;

int empty() {
	return (top == -1);
}
int full() {
	return (MAX - 1 == top);
}
void push(double item) {
	if (full()) {
		return;
	}
	stack[++top] = item;
}
double pop() {
	if (empty()) {
		return 0;
	}
	return stack[top--];
}
// 우선순위 결정
int  E(char data) {
	switch (data) {
	case '(':
		return 0;
		break;
	case '+':
	case '-':
		return 1;
		break;
	case '*':
	case '/':
		return 2;
		break;
	default:
		break;
	}
}
// 식 변환
void itop() {
	int temp, data;
	int len = strlen(infix);

	for (int i = 0; i < len; i++) {
		data = infix[i];
		switch (data) {
		case '(':
			push(data);
			break;
		case ')':
			temp = pop();//첫번째 데이터를 빼고 데이터 관찰.
			while (temp != '(') {//해당 문자가 나올때까지 pop 반복.
				postfix[++p_top] = temp;
				temp = pop();
			}
			break;
		case '+':
		case '-':
		case '*':
		case '/':
			while (top != -1 && E(data) <= E(stack[top])) {
				postfix[++p_top] = pop();
			}
			push(data);
			break;
		default:
			postfix[++p_top] = data;
			break;
		}
	}
	while (top != -1) {
		postfix[++p_top] = pop();
	}
	postfix[++p_top] = '\0';
}
int main() {
	scanf("%s", infix);

	itop();
	printf("%s", postfix);
}