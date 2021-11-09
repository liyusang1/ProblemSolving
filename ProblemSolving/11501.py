# 11501
from sys import stdin

n = int(stdin.readline())

for i in range(n):
    result = 0
    count = int(stdin.readline())
    numberList = list(map(int, stdin.readline().split()))

    temp = numberList[-1]
    for i in range(len(numberList) - 1, -1, -1):
        if numberList[i] > temp:
            temp = numberList[i]
        else:
            result += temp - numberList[i]

    print(result)
