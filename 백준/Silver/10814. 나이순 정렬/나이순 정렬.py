import sys
input = sys.stdin.readline

N = int(input())
user_dict = []
for i in range(N):
    age, name = input().split()
    age = int(age)
    user_dict.append((age, name))
user_dict.sort(key=lambda x: x[0])
for key,value in user_dict:
    print(key, value)