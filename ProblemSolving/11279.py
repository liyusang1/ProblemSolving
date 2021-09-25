# 11279
# BOJ 1927과 짝궁 문제 heapq를 이용해 최대힙을 구현
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
        heapq.heappush(priorityQueue, (-1*testCase,testCase))
