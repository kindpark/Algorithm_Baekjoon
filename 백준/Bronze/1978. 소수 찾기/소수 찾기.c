#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int a;
	int pn= 0;
	scanf("%d", &a);
	int* arr = (int*)malloc(sizeof(int) * a);
	for (int i = 0; i < a; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < a; i++) {
		for (int j = 2; j < arr[i]; j++) {
			if (arr[i] % j == 0) {
				break;
			}
			if(arr[i] == j+1) {
				pn++;
			}
		}
		if (arr[i] == 2) {
			pn++;
		}
	}
	printf("%d", pn);
}