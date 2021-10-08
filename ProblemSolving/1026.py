# 1026
from sys import stdin

n = int(stdin.readline())

A = list(map(int, stdin.readline().split()))
B = list(map(int, stdin.readline().split()))
A.sort()
B.sort(reverse=True)

result = 0
for i in range(n):
    result += A[i] * B[i]
print(result)
