
#include <stdio.h>
#include <stdlib.h>

int arr[100001];
int idx = 0;
void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}
void insert(int data) {
	int size = ++idx;
	while ((size != 1) && (data > arr[size / 2])) {
		arr[size] = arr[size / 2];
		size /= 2;
	}
	arr[size] = data;
}
int deleteheap() {
	if (idx == 0)
		return 0;
	int value = arr[1];
	arr[1] = arr[idx--];
	int parent = 1;
	int child;

	while (1) {
		child = parent * 2;
		if (child + 1 <= idx && arr[child] < arr[child + 1])
			child++;

		if (child > idx || arr[child] < arr[parent])
			break;

		swap(&arr[parent], &arr[child]);
		parent = child;
	}

	return value;

}
int main() {
	int n, x;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &x);
		if (x == 0)
		{
			printf("%d\n", deleteheap());
		}
		else
		{
			insert(x);
		}
	}
}
