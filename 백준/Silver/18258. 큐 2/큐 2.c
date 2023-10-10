#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct queue {
	int front;
	int rear;
	int arr[2000001];
}queue;
int i = 0;
void init(queue* q) {
	q->front = -1;
	q->rear = -1;
}
void enqueue(queue* q, int data) {

		q->arr[++q->rear] = data;
		i++;
}
int dequeue(queue* q) {
	if (empty(q)) {
		return -1;
	}
	else {
		i--;
		return q->arr[++(q->front)];
	}
}
int empty(queue* q) {
	if (q->rear == q->front) {
		return 1;
	}
	else {
		return 0;
	}
}
int size(queue* q) {
	return i;
}
int front(queue* q) {
	if (empty(q)) {
		return -1;
	}
	else {
		return q->arr[q->front + 1];
	}
}
int back(queue* q) {
	if (empty(q)) {
		return -1;
	}
	else {
		return q->arr[q->rear];
	}
}
int main() {
	queue q;
	init(&q);
	int n, p;
	scanf("%d", &n);
	char* a = (char*)malloc(sizeof(char)* 100);
	for (int i = 0; i < n; i++) {
		scanf("%s", a);
		if (!strcmp(a, "push")) {
			scanf("%d", &p);
			enqueue(&q, p);
		}
		if (!strcmp(a, "pop")) {
			printf("%d\n", dequeue(&q));
		}
		if (!strcmp(a, "size")) {
			printf("%d\n", size(&q));
		}
		if (!strcmp(a, "empty")) {
			printf("%d\n", empty(&q));
		}
		if (!strcmp(a, "front")) {
			printf("%d\n", front(&q));
		}
		if (!strcmp(a, "back")) {
			printf("%d\n", back(&q));
		}
	}
}