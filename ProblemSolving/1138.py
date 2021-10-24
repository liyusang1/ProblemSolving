# 1138

from sys import stdin

n = int(stdin.readline())

numberList = list(map(int, stdin.readline().split()))
result = []

for i in range(n):
    result.insert(numberList[n - 1 - i], n - i)

for i in result:
    print(i, end=" ")
