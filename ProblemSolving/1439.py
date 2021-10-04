# 1439
from sys import stdin

myList = list(map(int, stdin.readline().rstrip()))

# change to 1
count1 = 0
for i in range(len(myList)):
    if i == len(myList) - 1 and myList[i] == 0:
        count1 += 1
        break
    if myList[i] == 0 and myList[i + 1] != 0:
        count1 += 1

# change to 0
count2 = 0
for i in range(len(myList)):
    if i == len(myList) - 1 and myList[i] == 1:
        count2 += 1
        break
    if myList[i] == 1 and myList[i + 1] != 1:
        count2 += 1

print(min(count1, count2))
