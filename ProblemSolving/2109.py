# 2109
from sys import stdin
import heapq

n = int(stdin.readline())
tempList = []
for i in range(n):
    d, p = map(int, stdin.readline().split())
    tempList.append([d, p])
tempList = sorted(tempList, key=lambda x: x[1])
priorityQueue = []

for i in tempList:
    heapq.heappush(priorityQueue, i[0])
    if len(priorityQueue) > i[1]:
        heapq.heappop(priorityQueue)
print(sum(priorityQueue))
