#include <bits/stdc++.h>
using namespace std;
long a = 0;
long b = 0;
int main(void) {
	cin >> a >> b;
	int res = 0;
	while(b > a) {
		if(b % 2 == 0) {
			b/=2;
		}
			// 뒷자리 1
		else if(b % 10 == 1) {
			b /= 10;
		}
			//아무것도 해당 안된다면 탈출
    	else {
			break;
		}
		res++;
	}
	if(b == a) {
		cout << res+1;
	}
	else {
		cout << -1;
	}
}
