n, m = map(int, input().split())
arr = list(map(int, input().split()))

res = 0

for i in range(n):
    sum = 0
    for j in range(i, n):
        sum += arr[j]
        if sum == m:
            res+=1
        elif sum > 10:
            continue

print(res)