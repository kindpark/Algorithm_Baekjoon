#include <stdio.h>

int main() {
	long long int n = 0, max =0, sum =0; // 범위를 잘 확인해야함.
	
	scanf("%d", &max);

	while (1) {
		n++;
		sum = sum + n;
		if (sum > max) {
			n--;
			break;
		}
	}
	printf("%d\n", n);
}