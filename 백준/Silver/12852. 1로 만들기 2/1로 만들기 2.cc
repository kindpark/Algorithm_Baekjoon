#include <bits/stdc++.h>
using namespace std;

int n;
int arr[10000001];
int memo[10000001];
int main(void) {
	cin >> n;
	arr[0] = 0;
	arr[1] = 0;
	for (int i = 2; i <= n; i++) {
		arr[i] = arr[i - 1] + 1;
		if (i % 2 == 0) {
			arr[i] = min(arr[i], arr[i / 2] + 1);
		}
		if (i % 3 == 0) {
			arr[i] = min(arr[i], arr[i / 3] + 1);
		}

	}
	cout << arr[n] << '\n';
	while (true) {
		cout << n << " ";
		if (n == 1) {
			break;
		}
		//메모라이징 해둔거 되짚어보기
		if (n % 2 == 0 && arr[n] - 1 == arr[n / 2]) {
			n /= 2;
		}
		else if (n % 3 == 0 && arr[n] - 1 == arr[n / 3]) {
			n /= 3;
		}
		else {
			n--;
		}
	}
}