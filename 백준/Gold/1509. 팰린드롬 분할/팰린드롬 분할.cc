#include <iostream>
#include <string>
using namespace std;
bool b[2503][2503];
int dp[2503];
int main() {
    cin.tie(0) -> sync_with_stdio(0);
    string s; cin >> s;
    int n = s.size();
    s = " " + s;
    for (int i = 1; i <= n; i++) b[i][i] = true;
    for (int i = 1; i < n; i++) b[i][i + 1] = (s[i] == s[i + 1]);
    for (int j = 2; j < n; j++) {
        for (int i = 1; i + j <= n; i++) {
            if (s[i] == s[i + j] && b[i + 1][i + j - 1]) b[i][i + j] = 1;
        }
    }
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
        dp[i] = 1e9;
        for (int j = 1; j <= i; j++) {
            if (b[j][i]) dp[i] = min(dp[i], dp[j - 1] + 1);
        }
    }
    cout << dp[n];
}