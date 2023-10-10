#include <stdio.h>
int in_order[100001], post_order[100001], position[100001];
void solve(int is, int ie, int ps, int pe) {
	if (is > ie || ps > pe) {
		return;
	}
	int root = post_order[pe];
    printf("%d ", root);
	int ir = position[root]; // in_order 배열 안 ir위치에 root값이 들어있다.
	int left = ir - is;
	solve(is, ir - 1, ps, ps + left - 1); //왼쪽 서브트리 탐색
	solve(ir + 1, ie, ps + left, pe - 1); // 오른쪽 서브트리 탐색
}
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &in_order[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &post_order[i]);
	}
	for (int i = 0; i < n; i++) {
		position[in_order[i]] = i; // in_order에서 값 i의 위치를 저장하는 position 배열
	}
	solve(0, n - 1, 0, n - 1);
	return 0;
}