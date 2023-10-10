#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main() {
	deque<int> d;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		string ch;	int num;
		cin >> ch;
		if (ch == "push_front") {
			cin >> num;
			d.push_front(num);
		}
		else if (ch == "push_back") {
			cin >> num;
			d.push_back(num);
		}
		else if (ch=="pop_front") {
			if (!d.empty()) { 
				cout << d.front() << endl;
				d.pop_front(); 
			}
			else { cout << -1 << endl; }
		}
		else if (ch == "pop_back") {
			if (!d.empty()) { 
				cout << d.back() << endl;
				d.pop_back(); 
			}
			else { cout << -1 << endl; }
		}
		else if(ch=="size"){
			cout << d.size() << endl;
		}
		else if (ch == "empty") {
			if (d.empty()) { cout << 1 << endl; }
			else { cout << 0 << endl; }
		}
		else if (ch == "front") {
			if (!d.empty()) { cout << d.front() << endl; }
			else { cout << -1 << endl; }
		}
		else if (ch == "back") {
			if (!d.empty()) { cout << d.back() << endl; }
			else { cout << -1 << endl; }
		}
	}
}