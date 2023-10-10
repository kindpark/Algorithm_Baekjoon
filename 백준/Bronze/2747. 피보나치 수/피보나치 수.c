#include <stdio.h>
int main() {
    long long arr[91];
    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i < 91; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    int n;
    scanf("%d", &n);
    printf("%lld", arr[n]);
}