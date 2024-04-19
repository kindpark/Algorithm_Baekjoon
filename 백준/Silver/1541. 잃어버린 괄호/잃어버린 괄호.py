import re
def solve():
    u = []
    s = input().split('-')
    for i in s:
        res = 0
        nums = i.split('+')
        for j in nums:
            res+=int(j)
        u.append(res)
    n = u[0]
    for i in range(1, len(u)):
        n -= u[i]
    return n

print(solve())
