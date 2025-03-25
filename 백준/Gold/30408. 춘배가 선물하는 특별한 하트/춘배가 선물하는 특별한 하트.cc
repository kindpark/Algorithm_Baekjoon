#include <iostream>
#include <unordered_set>
#include <sstream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long N, M;
    string input;
    getline(cin, input);
    stringstream ss(input);
    ss >> N >> M;

    unordered_set<long long> set;
    set.insert(N);

    bool isOdd = (N % 2 != 0);
    
    while (N > 1) {
        if (isOdd) {
            N /= 2;
            long long temp = N;
            set.insert(temp);
            set.insert(temp + 1);
        } else { 
            if (N % 2 == 0) {
                N /= 2;
                long long temp = N;
                set.insert(temp);
            } else {
                isOdd = true;
                N = (N - 1) / 2;
                long long temp = N;
                set.insert(temp);
                set.insert(temp + 1);
            }
        }
    }

    cout << (set.count(M) ? "YES" : "NO") << "\n";
    return 0;
}