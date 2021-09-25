#1927
import heapq
from sys import stdin

n = int(stdin.readline())

priorityQueue = []
for _ in range(n):
    testCase = int(stdin.readline())
    if testCase == 0 and len(priorityQueue) != 0:
        print(heapq.heappop(priorityQueue))
    elif testCase == 0 and len(priorityQueue) == 0:
        print(0)
    else:
        heapq.heappush(priorityQueue, testCase)
