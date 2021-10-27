# 9237

from sys import stdin

n = int(stdin.readline())
numberList = list(map(int, stdin.readline().strip().split()))
numberList.sort(reverse=True)

result = []

for i in range(len(numberList)):
    result.append(numberList[i] + i + 1)

print(max(result) + 1)
