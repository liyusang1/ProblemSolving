# 15903
from sys import stdin

n, m = map(int, stdin.readline().split())
numberList = list(map(int, stdin.readline().split()))


def solution():
    numberList.sort()
    temp = numberList[0] + numberList[1]
    numberList[0], numberList[1] = temp, temp


for _ in range(m):
    solution()

print(sum(numberList))
