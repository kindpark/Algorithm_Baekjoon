#include <bits/stdc++.h>
#include<bits/stdc++.h>
using namespace std;
const int maxn = 3007;
int n, t, s;
int dp[maxn][maxn];
int A[maxn], B[maxn];

int main()
{
	cin >> n >> t >> s;

	for(int i = 1; i <= n; i++)
        cin >> A[i] >> B[i];

	memset(dp, 0, sizeof(dp));
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= t; j++)
		{
			dp[i][j] = dp[i - 1][j];
			dp[i][j] = max(dp[i][j], dp[i][j - 1]);

			if (j >= B[i] && !(j - B[i]<s && j>s))
				dp[i][j] = max(dp[i][j], dp[i - 1][j - B[i]] + A[i]);


		}

	cout << dp[n][t] << endl;

	return 0;
}
