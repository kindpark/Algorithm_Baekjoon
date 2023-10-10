#테스트용
#맞아도 다시 풀거임
N = int(input())
arr = list(map(int, input().split()))

def next_permutation(arr):
    i = N - 1
    while 0 < i and arr[i - 1] >= arr[i]:
        i -= 1
    if i <= 0:
        print(-1)
        return 
    
    j = N - 1
    while arr[i - 1] >= arr[j]:
        j -= 1
    
    arr[i - 1], arr[j] = arr[j], arr[i - 1]

    arr = arr[:i] + sorted(arr[i:])
    print(*arr)
    return

next_permutation(arr)