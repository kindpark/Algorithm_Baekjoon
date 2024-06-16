import sys
input = sys.stdin.read

def main():
    data = input().split()
    n, b = int(data[0]), int(data[1])
    P = [0] * n
    S = [0] * n

    index = 2
    for i in range(n):
        P[i] = int(data[index])
        S[i] = int(data[index + 1])
        index += 2

    done = False
    while not done:
        done = True
        for i in range(n - 1):
            if P[i] + S[i] > P[i + 1] + S[i + 1]:
                P[i], P[i + 1] = P[i + 1], P[i]
                S[i], S[i + 1] = S[i + 1], S[i]
                done = False

    def select(a):
        bg = b - (P[a] // 2 + S[a])
        t = 1
        if bg < 0:
            return 0
        for j in range(n):
            if P[j] + S[j] <= bg and j != a:
                bg -= (P[j] + S[j])
                t += 1
        return t

    res = 0
    for i in range(n):
        result = select(i)
        if result > res:
            res = result

    print(res)

if __name__ == "__main__":
    main()