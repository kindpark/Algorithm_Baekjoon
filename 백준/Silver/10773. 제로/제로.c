#include <stdio.h>
#include <stdlib.h>
typedef struct arrstack {
	int arr[100000];
	int t;
}stack;
void StackInit(stack* stack);
void StackPush(stack * stack, int data);
int StackPop(stack* stack);
int StackEmpty(stack* stack);
int StackPeek(stack* stack);
int main(void) {
	stack stack;
	StackInit(&stack);
	int k;
	int sum = 0;
	int out = 0;
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		int a;
		scanf("%d", &a);
		if (a == 0) {
			StackPop(&stack);
			out++;
		}
		else {
			StackPush(&stack, a);
		}
	}
	int* arr = (int*)malloc(sizeof(int) * (k - out));
	for (int i = 0; i < k - (out*2); i++) {
		sum += StackPop(&stack);
	}
	printf("%d", sum);

}
int StackEmpty(stack* stack) {
	if (stack->t == -1) {
		return 0;
	}
	else {
		return 1;
	}
}
void StackInit(stack* stack) {
	stack->t = -1;
}
void StackPush(stack* stack, int data) {
	stack->t += 1;
	stack->arr[stack->t] = data;
}
int StackPop(stack* stack) {
	int a;
	a = stack->t;
	stack->t -= 1;
	return stack->arr[a];
}
int StackPeek(stack* stack) {
	return stack->arr[stack->t];
}