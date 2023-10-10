import sys

# N: 데이터 개수
N = int(sys.stdin.readline().rstrip())

array = []
for i in range(N):
    array.append(sys.stdin.readline().rstrip())

array = list(set(array))
array = sorted(array, key = lambda x : (len(x), x))

for i in range(len(array)):
    print(array[i])