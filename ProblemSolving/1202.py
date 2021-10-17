# 1202
from sys import stdin
import heapq

n, k = map(int, stdin.readline().split())

jew = []
bag = []

for _ in range(n):
    heapq.heappush(jew, list(map(int, stdin.readline().split())))

for _ in range(k):
    bag.append(int(stdin.readline()))

bag.sort()
answer = 0
temp = []
for i in bag:
    while jew and i >= jew[0][0]:
        heapq.heappush(temp, -heapq.heappop(jew)[1])
    if temp:
        answer -= heapq.heappop(temp)
    elif not jew:
        break
print(answer)