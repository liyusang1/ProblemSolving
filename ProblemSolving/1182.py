# 1182

from sys import stdin
from itertools import combinations

numberCount, sumValue = map(int, stdin.readline().split())

numberList = list(map(int, stdin.readline().split()))

count = 0
for _ in range(1, numberCount + 1):
    temp = list(i for i in combinations(numberList, _))
    for i in temp:
        if sum(i) == sumValue:
            count += 1

print(count)
