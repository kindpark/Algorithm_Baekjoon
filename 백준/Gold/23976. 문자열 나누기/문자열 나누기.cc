#include <bits/stdc++.h>
using namespace std;
//참고함

int main() {
    int MOD = 1000000007;
    char str[2501];
    int dp[2501][2501][2];
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	int n, k;
	cin >> n >> k;
	for(int i = 1; i <= n; i++) {
		cin >> str[i];
	}
	if (str[1] == '0') {
		dp[1][1][1] = 1;
	}
	else if (str[1] != '0') {
		dp[1][1][0] = 1;
	}
	for(int i = 2; i <= n; i++) {
		for(int j = 1; j <= i; j++) {
			if (str[i] == '0') {
				dp[i][j][0] = dp[i - 1][j][0];
				dp[i][j][1] = (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD;
			}
			else if (str[i] != '0') {
				dp[i][j][0] = ((dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD + dp[i - 1][j][0]) % MOD;
			}
		}
	}
	printf("%d",(dp[n][k][0] + dp[n][k][1]) % MOD);

	return 0;
}