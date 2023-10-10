#include <stdio.h>
#include <stdlib.h>

typedef struct stack {
	char arr[51];
	int index;
}stack;
int empty(stack* stack) {
	if (stack->index == -1) {
		return 0;
	}
	else {
		return 1;
	}
}
void init(stack* stack) {
	stack->index = -1;
}
void insert(stack* stack, char data) {
	
	stack->index++;
	stack->arr[stack->index] = data;

}
char pop(stack* stack) {
	char d = stack->arr[stack->index];
	stack->arr[stack->index] = NULL;
	stack->index--;

	return d;
}
char peek(stack* stack) {
	return stack->arr[stack->index];
}
char disp(stack* stack) {
	for (int i = 0; i < 51; i++) {

	}
}
void result(stack* stack) {
	char input[51];
	int a = 0;
	gets(input);
	for (int i = 0; i < strlen(input); i++) {
		if (input[0] == NULL) {
			insert(stack, input[0]);
		}
		else {
			if (peek(stack) == '(' && input[i] == ')') {
				pop(stack);
			}
			else {
				insert(stack, input[i]);
			}
		}
	}
	for (int i = 0; i < strlen(stack->arr); i++) {
		if (stack->arr[i] == NULL) {
			break;
		}
		else {
			if (stack->arr[i] == '(' || stack->arr[i] == ')') {
				a++;
			}
		}
	}
	printf("%d", a);
}
int main(void) {
	stack stack;
	init(&stack);
	
	result(&stack);
}