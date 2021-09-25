#11286

#BOJ 11279,BOJ 11286과 매우 유사한 문제
import heapq
from sys import stdin

n = int(stdin.readline())

priorityQueue = []
for _ in range(n):
    testCase = int(stdin.readline())
    if testCase == 0 and len(priorityQueue) != 0:
        x,y = heapq.heappop(priorityQueue)
        print(y)
    elif testCase == 0 and len(priorityQueue) == 0:
        print(0)
    else:
        heapq.heappush(priorityQueue, (abs(testCase),testCase))
