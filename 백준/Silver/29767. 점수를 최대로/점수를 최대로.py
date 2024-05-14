import sys

n, k = map(int, sys.stdin.readline().split())
room = list(map(int, sys.stdin.readline().split()))
s = [0] * n
res = 0

s[0] = room[0]
for i in range(1, n):
    s[i] = room[i] + s[i-1]

s.sort(reverse=True)

for i in range(k):
    res += s[i]

print(res)
