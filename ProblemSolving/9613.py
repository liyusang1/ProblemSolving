# 9613

from math import gcd
from itertools import combinations
from sys import stdin

n = int(stdin.readline())

for _ in range(n):
    numList = list(map(int,stdin.readline().split()))
    numList.pop(0)
    comList = list(combinations(numList,2))

    count = 0
    for x,y in comList:
        count += gcd(x,y)
    print(count)