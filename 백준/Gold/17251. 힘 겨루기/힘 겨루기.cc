
#include <iostream>
#include <queue>
#include <stdio.h>

using namespace std;

int main() {
	int n; 
	int temp=0;
	int max = 0;
	int left, right;
	queue<int> maxn;
	cin >> n; 


	for (int i = 0; i < n; i++) {
		scanf(" %d", &temp);
		if (temp > max) {
			while (!maxn.empty())
				maxn.pop();
			maxn.push(i);
			max = temp;
		}
		else if (temp == max) {
			maxn.push(i);
		}
	}

	if (maxn.size() == 1) {
		left = maxn.front();
		right = n - left-1;
	}
	else {
		left = maxn.front();
		while (!maxn.empty()) {
			temp = maxn.front();
			maxn.pop();
		}
		right = n - temp - 1;
	}
	if (left > right)
		cout << "B";
	else if (left < right)
		cout << "R";
	else
		cout << "X";
	return 0;
}