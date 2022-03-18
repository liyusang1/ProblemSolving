# 10816
from sys import stdin

n = int(stdin.readline())
numberList = list(map(int, stdin.readline().split()))

dic = dict()
for i in numberList:
    if not i in dic:
        dic[i] = 1
    else:
        dic[i] += 1

k = int(stdin.readline())
numberList2 = list(map(int, stdin.readline().split()))

for i in numberList2:
    if i in dic:
        print(dic[i], end=" ")
    else:
        print(0, end=" ")
