#include <stdio.h>
#include <stdlib.h>

int arr[25000000];
int rear = -1;
int front = -1;

void enqueue(int data) {
	if (rear >= 25000000) {
		return;
	}
	else {
		arr[++rear] = data;
	}
}
int dequeue() {
	return arr[++front];
}
int peek() {
	return arr[rear];
}
int run() {
	while(rear != front){
		for (int i = 0; i < 2; i++) {
			if (i == 1) {
				enqueue(dequeue());
			}
			else {
				dequeue();
			}
		}
	}
	printf("%d", arr[rear-1]);
}
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		enqueue(i);
	}
	run();

}