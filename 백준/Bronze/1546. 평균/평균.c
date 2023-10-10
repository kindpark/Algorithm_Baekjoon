#include <stdio.h>

int main() {
	int s;
	float t = 0.0;
	scanf("%d", &s);
	float a[1000] = {0};
	for (int i = 0; i < s; i++) {
		scanf("%f", &a[i]);
	}
	for (int i = 0; i < s; i++) {
		if (t < a[i]) {
			t = a[i];
		}
	}
	for (int i = 0; i < s; i++) {
		a[i] = a[i] / t * 100;
	}
	float k = 0;
	for (int i = 0; i < s; i++) {
		k += a[i];
	}
	float newavg1 = k / s;
	printf("%f", newavg1);
}