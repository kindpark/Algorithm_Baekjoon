#include <bits/stdc++.h>
using namespace std;

int page = 0;
int book[10];
//자릿수를 더하는 코드
////https://mygumi.tistory.com/180
void ntonine(int b, int book[], int pt) {
	while (b > 0) {
		//나누어질때까지
		//페이지 출력
		book[b % 10] += pt;
		//메모라이징
		b /= 10;
	}
}
int main(void) {
	cin >> page;
	int pt = 1;
	int b = 1;
	//페이지가 끝날때 까지 페이지 출력
	while (b <= page) {
		// 끝자리 9로 만들기
		while (page % 10 != 9 && b <= page) {
			ntonine(page, book, pt);
			page--;
		}
		if (b > page) {
			break;
		}
		// 끝자리 0으로 만들기
		while (b % 10 != 0 && b <= page) {
			ntonine(b, book, pt);
			b++;
		}
		b /= 10;
		page /= 10;
		for (int i = 0; i < 10; i++) {
			book[i] += (page - b + 1) * pt;
		}
		pt *= 10;
	}
	for (int i = 0; i < 10; i++) {
		cout << book[i] << " ";
	}
}
