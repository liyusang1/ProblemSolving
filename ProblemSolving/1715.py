from sys import stdin
import heapq

n = int(stdin.readline())
priorityQueue = []

for _ in range(n):
    heapq.heappush(priorityQueue, int(stdin.readline()))

result = 0
while len(priorityQueue) > 1:
    temp1 = heapq.heappop(priorityQueue)
    temp2 = heapq.heappop(priorityQueue)
    result += temp1 + temp2
    # priorityQueue에 다시 넣는 것이 point!
    heapq.heappush(priorityQueue, temp1 + temp2)

print(result)
