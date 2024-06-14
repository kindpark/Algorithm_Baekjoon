n, k = map(int, input().split())
w = []
v = []
for i in range(n):
    wi, vi = map(int, input().split())
    w.append(wi)
    v.append(vi)

dp = [[0 for j in range(k+1)]for i in range(n+1)]

for i in range(1, n+1):
    for j in range(k+1):
        if w[i-1] > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1])

print(dp[n][k])

