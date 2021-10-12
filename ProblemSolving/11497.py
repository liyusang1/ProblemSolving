# 11497
from sys import stdin

n = int(stdin.readline())

for _ in range(n):
    m = int(stdin.readline())
    numberList = list(map(int, stdin.readline().split()))
    numberList.sort()
    maximum = 0
    for i in range(2, m):
        maximum = max(maximum, numberList[i] - numberList[i - 2])
    print(maximum)
